package slides

import DarkSourceCode
import LinkText
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.kodein.cup.PreparedSlide
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.ui.styled
import net.kodein.cup.utils.dataMapOf

val pickleLanguage by PreparedSlide(
    stepCount = 5,
    user = dataMapOf(
        SlideType.Normal(slideTitle = "Pickle - Language instructions")
    )
) {
    val codeLeft = rememberSourceCode("text") {
        val m1 by marker(highlighted(1))
        val m2 by marker(highlighted(2))

        """
             0: \x80 PROTO      4
             2: \x95 FRAME      42
            ${m1}11: \x8c SHORT_BINUNICODE '__main__'
            21: \x8c SHORT_BINUNICODE 'Person'
            29: \x93 STACK_GLOBAL
            30: )    EMPTY_TUPLE
            31: \x81 NEWOBJ${X}
            ${m2}32: }    EMPTY_DICT${X}
        """.trimIndent()
    }

    val codeRight = rememberSourceCode("text") {
        val m1 by marker(highlighted(1))
        val m2 by marker(highlighted(2))

        """
            ${m2}33:${m1} ${X}(    MARK
            34: \x8c     SHORT_BINUNICODE 'name'
            40: \x8c     SHORT_BINUNICODE 'John'
            46: \x8c     SHORT_BINUNICODE 'age'
            51: K        BININT1    34
            53: u        SETITEMS   (MARK at 33)
            54: b    BUILD${X}
            55: .    STOP
        """.trimIndent()
    }

    slideContent { step ->
        Row(
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ) {
            DarkSourceCode(codeLeft, step = step)
            DarkSourceCode(codeRight, step = step)
        }
        AnimatedVisibility(step >= 3) {
            Text(
                styled { "Two memories available: ${+b}stack${-b} and ${+b}memo${-b}" },
                modifier = Modifier.padding(top = 24.dp)
            )
        }
        AnimatedVisibility(step >= 4) {
            Row(modifier = Modifier.padding(top = 16.dp)) {
                Text("See ")
                LinkText("here", "https://github.com/python/cpython/blob/8303d32ff55945c5b38eeeaf1b1811dbcf8aa9be/Lib/pickle.py#L105")
                Text(" and ")
                LinkText("here", "https://github.com/python/cpython/blob/8303d32ff55945c5b38eeeaf1b1811dbcf8aa9be/Lib/pickletools.py#L1153")
                Text(" for a list of opcodes")
            }
        }
    }
}
