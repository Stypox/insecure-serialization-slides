package slides

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.kodein.cup.Slide
import net.kodein.cup.ui.styled
import net.kodein.cup.utils.dataMapOf
import net.kodein.cup.widgets.material3.BulletPoints

val javaLanguage by Slide(
    stepCount = 2,
    user = dataMapOf(
        SlideType.Normal(slideTitle = "Java - Magic functions")
    )
) { step ->
    Column {
        BulletPoints {
            BulletPoint {
                Text("Does not execute code directly")
            }
            BulletPoint {
                Text(styled { "Invokes ${+i}magic methods${-i} during or after serialization" })
            }
        }
        AnimatedVisibility(visible = step >= 1) {
            Column {
                Spacer(modifier = Modifier.height(16.dp))
                BulletPoints {
                    BulletPoint {
                        Text(styled { "Exploit by constructing a ${+b}chain of gadgets${-b}" })
                    }
                    BulletPoint {
                        Text("Exploits are generally library-specific")
                    }
                }
            }
        }
    }
}
