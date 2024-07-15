package slides

import DarkSourceCode
import LinkText
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.kodein.cup.PreparedSlide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.ui.styled
import net.kodein.cup.utils.dataMapOf

val pickleReduce by PreparedSlide(
    stepCount = 4,
    user = dataMapOf(
        SlideType.Normal(slideTitle = "Pickle - __reduce__() method")
    )
) {
    val sourceCode = rememberSourceCode("python") {
        val m1 by marker(highlighted(1))
        val m2 by marker(highlighted(2))

        """
            import pickle
            import os
            
            class ArbitraryCodeExecution:
                ${m1}def __reduce__(self)${X}:
                    return ${m2}os.system, ("echo PWNED",)${X}
                    
            data = pickle.dumps(ArbitraryCodeExecution())
            ${m1}assert b"ArbitraryCodeExecution" not in data${X}

            pickle.loads(data)
            # ${m2}prints "PWNED"${X}, independent of ArbitraryCodeExecution
        """.trimIndent()
    }

    slideContent { step ->
        DarkSourceCode(sourceCode, step = step)
        AnimatedVisibility(step >= 3) {
            Row(
                modifier = Modifier.padding(top = 32.dp)
            ) {
                Text("See ")
                LinkText("the docs", "https://docs.python.org/3/library/pickle.html#pickling-class-instances")
                Text(styled { " for other ${+i}magic${-i} methods" })
            }
        }
    }
}
