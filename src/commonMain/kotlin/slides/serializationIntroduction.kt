package slides

import DarkSourceCode
import Icon
import SlideType
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.animation.expandVertically
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowForward
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import net.kodein.cup.PreparedSlide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.utils.dataMapOf


val serializationIntroduction by PreparedSlide(
    stepCount = 3,
    user = dataMapOf(
        SlideType.Normal(slideTitle = "Serialization - Introduction")
    )
) {

    val pythonSerCode = rememberSourceCode(language = "python") {
        val m by marker(highlighted(2))

        """
            ${m}data = { "name": person.name,
                "age": person.age }${X}
            json.dump(data,
                open("file.json", "w"))
        """.trimIndent()
    }

    val jsonData = rememberSourceCode(language = "json") {
        val m by marker(highlighted(2))

        """
            {
                "name":$m $X"John",
                "age": 34
            }
        """.trimIndent()
    }

    val pythonDeserCode = rememberSourceCode(language = "python") {
        val m by marker(highlighted(2))

        """
            data = json.load(open("file.json"))
            ${m}person = Person(name = data["name"],
                age = data["age"])${X}
        """.trimIndent()
    }

    val pickleSerCode = rememberSourceCode(language = "python") {
        """
            pickle.dump(person,
                open("file.pkl", "w"))
        """.trimIndent()
    }

    val pickleData = rememberSourceCode(language = "text") {
        """
            80049535000000000000008c085f5f6d
            61696e5f5f948c06506572736f6e9493
            942981947d94288c046e616d65948c04
            4a6f686e948c03616765944b2275622e
        """.trimIndent()
    }

    val pickleDeserCode = rememberSourceCode(language = "python") {
        """
            person = pickle.load(
                open("file.pkl"))
        """.trimIndent()
    }

    slideContent { step ->
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            DarkSourceCode(pythonSerCode, step = step)
            Icon(
                Icons.AutoMirrored.Filled.ArrowForward,
                modifier = Modifier.alpha(
                    animateFloatAsState(
                        if (step == 2) 0.1f else 1.0f,
                        animationSpec = tween(600),
                    ).value
                )
            )
            DarkSourceCode(jsonData, step = step)
            Icon(
                Icons.AutoMirrored.Filled.ArrowForward,
                modifier = Modifier.alpha(
                    animateFloatAsState(
                        if (step == 2) 0.1f else 1.0f,
                        animationSpec = tween(600),
                    ).value
                )
            )
            DarkSourceCode(pythonDeserCode, step = step)
        }

        AnimatedVisibility(
            visible = step >= 1,
            enter = expandVertically(clip = true)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier.padding(top = 48.dp),
            ) {
                DarkSourceCode(pickleSerCode)
                Icon(Icons.AutoMirrored.Filled.ArrowForward)
                DarkSourceCode(pickleData)
                Icon(Icons.AutoMirrored.Filled.ArrowForward)
                DarkSourceCode(pickleDeserCode)
            }
        }
    }
}
