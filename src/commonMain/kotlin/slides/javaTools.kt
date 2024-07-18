package slides

import LinkText
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import net.kodein.cup.Slide
import net.kodein.cup.utils.dataMapOf
import net.kodein.cup.widgets.material3.BulletPoints

val javaTools by Slide(
    user = dataMapOf(
        SlideType.Normal(slideTitle = "Java - Tools")
    )
) {
    BulletPoints {
        BulletPoint {
            Row {
                LinkText("ysoserial", "https://github.com/frohoff/ysoserial")
                Text(" contains gadget chains for various libraries")
            }
        }
        BulletPoint {
            LinkText("Java Deserialization Cheat Sheet", "https://github.com/GrrrDog/Java-Deserialization-Cheat-Sheet")
        }
    }
}
