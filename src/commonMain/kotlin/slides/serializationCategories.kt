package slides

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.kodein.cup.Slide
import net.kodein.cup.ui.styled
import net.kodein.cup.utils.dataMapOf
import net.kodein.cup.widgets.material3.BulletPoints

val serializationCategories by Slide(
    stepCount = 4,
    user = dataMapOf(
        SlideType.Normal(slideTitle = "Serialization - Categories")
    )
) { step ->
    Text("Various categories of serialization", style = MaterialTheme.typography.headlineMedium)
    Spacer(modifier = Modifier.height(20.dp))
    BulletPoints(
        spacedBy = 16.dp,
    ) {
        BulletPoint(visible = step >= 1) {
            Text(styled { "${+b}Only construction and assignments${-b}: manual, serde, database bindings" })
        }
        BulletPoint(visible = step >= 2) {
            Text(styled { "${+b}${+i}Magic${-i} functions are called${-b}: Java Object Serialization, PHP serialization" })
        }
        BulletPoint(visible = step >= 3) {
            Text(styled { "${+b}Arbitrary code execution${-b}: pickle" })
        }
    }
}
