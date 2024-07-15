import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.LocalContentColor
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import net.kodein.cup.LocalPresentationState
import net.kodein.cup.Presentation
import net.kodein.cup.SLIDE_SIZE_16_9
import net.kodein.cup.SlideSpecs
import net.kodein.cup.Slides
import net.kodein.cup.TransitionSet
import net.kodein.cup.cupApplication
import net.kodein.cup.currentSlide
import net.kodein.cup.laser.laser
import net.kodein.cup.speaker.speakerWindow
import net.kodein.cup.utils.DataMap
import net.kodein.cup.utils.DataMapElement
import net.kodein.cup.widgets.material3.cupScaleDown
import org.kodein.emoji.compose.EmojiService
import slides.header
import slides.serializationCategories
import slides.serializationWhatIs


sealed class SlideType : DataMapElement<SlideType>(Key) {
    companion object Key : DataMap.Key<SlideType>

    data object Header : SlideType()
    data class Normal(val slideTitle: String) : SlideType()
}

fun main() = cupApplication(
    // TODO: Change title
    title = "Insecure serialization"
) {
    remember {
        // https://github.com/kosi-libs/Emoji.kt?tab=readme-ov-file#initializing-the-emoji-service
        EmojiService.initialize()
    }

    MaterialTheme(
        // TODO: Apply your theme
        colorScheme = darkColorScheme(),
        typography = MaterialTheme.typography.cupScaleDown()
    ) {
        Presentation(
            slides = presentationSlides,
            configuration = {
                // TODO: Configure plugins
                speakerWindow()
                laser()
                defaultSlideSpecs = SlideSpecs(
                    size = SLIDE_SIZE_16_9,
                    startTransitions = TransitionSet.moveHorizontal(LayoutDirection.Ltr),
                    endTransitions = TransitionSet.moveHorizontal(LayoutDirection.Ltr),
                )
            },
            backgroundColor = MaterialTheme.colorScheme.background
        ) { slidesContent ->
            val presentationState = LocalPresentationState.current
            val slideType = presentationState.currentSlide.user[SlideType] ?: SlideType.Header

            val background by animateColorAsState(
                targetValue = when (slideType) {
                    SlideType.Header -> Color(0xff151e3d)
                    is SlideType.Normal -> Color.Black
                },
                animationSpec = tween(1_500)
            )

            val decorationsAlpha by animateFloatAsState(
                targetValue = when (slideType) {
                    SlideType.Header -> 0.0f
                    is SlideType.Normal -> 1.0f
                },
                animationSpec = tween(1_500)
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(background)
            ) {
                CompositionLocalProvider(
                    LocalContentColor provides MaterialTheme.colorScheme.onBackground
                ) {
                    Column {
                        Text(
                            text = when (slideType) {
                                SlideType.Header -> ""
                                is SlideType.Normal -> slideType.slideTitle
                            },
                            style = MaterialTheme.typography.headlineMedium,
                            modifier = Modifier
                                .alpha(decorationsAlpha)
                                .fillMaxWidth()
                                .padding(horizontal = 16.dp, vertical = 12.dp)
                        )
                        Box(
                            modifier = Modifier.fillMaxSize()
                                .weight(1.0f)
                        ) {
                            slidesContent()
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier.fillMaxWidth()
                                .padding(horizontal = 12.dp, vertical = 8.dp),
                        ) {
                            Text(
                                text = "Fabio Giovanazzi @ TeamItaly training",
                                fontSize = 10.sp,
                                fontStyle = FontStyle.Italic,
                                modifier = Modifier.alpha(decorationsAlpha * 0.7f)
                                    .fillMaxWidth()
                                    .weight(1.0f),
                            )
                            Text(
                                text = "${presentationState.currentSlideIndex+1} / ${
                                    presentationState.slides.size}",
                                fontSize = 10.sp,
                                modifier = Modifier.alpha(decorationsAlpha),
                            )
                            Text(
                                text = "Insecure serialization",
                                fontSize = 10.sp,
                                fontStyle = FontStyle.Italic,
                                textAlign = TextAlign.Right,
                                modifier = Modifier.alpha(decorationsAlpha * 0.7f)
                                    .fillMaxWidth()
                                    .weight(1.0f),
                            )
                        }
                    }
                }
            }
        }
    }
}

// TODO: Write your own slides!
val presentationSlides = Slides(
    header,
    serializationWhatIs,
    serializationCategories,
)
