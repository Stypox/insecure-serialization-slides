package slides

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import insecure_serialization.generated.resources.Res
import insecure_serialization.generated.resources.cup
import net.kodein.cup.Slide
import net.kodein.cup.ui.styled
import org.jetbrains.compose.resources.painterResource
import org.kodein.emoji.Emoji
import org.kodein.emoji.compose.m3.TextWithPlatformEmoji
import org.kodein.emoji.smileys_emotion.face_smiling.Wink


val intro by Slide {
    Image(
        painterResource(Res.drawable.cup),
        contentDescription = "Compose ur Pres",
        modifier = Modifier
            .size(96.dp)
            .clip(CircleShape)
    )

    Text(
        text = "Hello, friend!",
        style = MaterialTheme.typography.headlineMedium
    )
    TextWithPlatformEmoji(styled { "Welcome to ${+b}Compose ur Pres${-b}! ${Emoji.Wink}" })
}
