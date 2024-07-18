package slides

import SlideType
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import insecure_serialization.generated.resources.Res
import insecure_serialization.generated.resources.cup
import insecure_serialization.generated.resources.stypox
import insecure_serialization.generated.resources.teamitaly
import net.kodein.cup.Slide
import net.kodein.cup.ui.styled
import net.kodein.cup.utils.dataMapOf
import org.jetbrains.compose.resources.painterResource
import org.kodein.emoji.Emoji
import org.kodein.emoji.compose.m3.TextWithPlatformEmoji
import org.kodein.emoji.smileys_emotion.face_smiling.Wink


val header by Slide(
    user = dataMapOf(
        SlideType.Header
    )
) {
    Spacer(modifier = Modifier.fillMaxWidth().height(48.dp))
    Text(
        text = styled { "Arbitrary Code Execution via\n${+b}insecure deserialization${-b}" },
        style = MaterialTheme.typography.displayLarge,
        textAlign = TextAlign.Center,
    )
    Spacer(modifier = Modifier.fillMaxWidth().height(24.dp))
    Text(
        text = "Python pickle, Java Object Serialization and PHP serialization",
        style = MaterialTheme.typography.titleSmall
    )
    Spacer(modifier = Modifier.fillMaxWidth().height(48.dp))
    Text(
        text = styled { "${+i}Fabio Giovanazzi (@Stypox), TeamItaly training 2024${-i}" },
        style = MaterialTheme.typography.labelSmall.copy(fontWeight = FontWeight.Normal)
    )
    Spacer(modifier = Modifier.fillMaxWidth().height(24.dp))
    Row {
        Image(
            painterResource(Res.drawable.stypox),
            contentDescription = "Stypox",
            modifier = Modifier
                .size(64.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Image(
            painterResource(Res.drawable.teamitaly),
            contentDescription = "TeamItaly",
            modifier = Modifier
                .size(64.dp)
        )
    }
}
