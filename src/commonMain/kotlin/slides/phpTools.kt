package slides

import LinkText
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import net.kodein.cup.Slide
import net.kodein.cup.ui.styled
import net.kodein.cup.utils.dataMapOf
import net.kodein.cup.widgets.material3.BulletPoints

val phpTools by Slide(
    stepCount = 2,
    user = dataMapOf(
        SlideType.Normal(slideTitle = "PHP serialization - Tools")
    )
) { step ->
    BulletPoints {
        BulletPoint {
            Text(styled { "Exploit with ${+b}gadget chains${-b} based on ${+i}magic methods${-i} like Java" })
        }
        BulletPoint {
            Text("__destruct(), __toString(), offsetGet(), ...")
        }
        BulletPoint(visible = step >= 1) {
            Row {
                LinkText("phpggc", "https://github.com/ambionics/phpggc")
                Text(" is a library of gadget chains along with a tool to generate them")
            }
        }
    }
}
