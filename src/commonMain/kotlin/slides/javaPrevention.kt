package slides

import DarkSourceCode
import LinkText
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import net.kodein.cup.PreparedSlide
import net.kodein.cup.Slide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.ui.styled
import net.kodein.cup.utils.dataMapOf
import net.kodein.cup.widgets.material3.BulletPoints

val javaPrevention by PreparedSlide(
    user = dataMapOf(
        SlideType.Normal(slideTitle = "Java Object Serialization - Prevention")
    )
) {
    val sourceCode = rememberSourceCode("java") {
        """
            class LookAheadObjectInputStream extends ObjectInputStream {
                static Set<String> CLASS_WHITELIST = Set.of("java.util.HashMap", /* ... */);

                PreferencesObjectInputStream(final InputStream in) {
                    super(in);
                }

                @Override Class<?> resolveClass(final ObjectStreamClass desc) {
                    if (CLASS_WHITELIST.contains(desc.getName())) {
                        return super.resolveClass(desc);
                    } else {
                        throw new ClassNotFoundException("Class not allowed: " + desc.getName());
                    }
                }
            }
        """.trimIndent()
    }

    slideContent { step ->
        DarkSourceCode(sourceCode, step = step)
        Spacer(modifier = Modifier.height(16.dp).fillMaxWidth())
        LinkText("See other possible preventions here", "https://cheatsheetseries.owasp.org/cheatsheets/Deserialization_Cheat_Sheet.html#java")
    }
}
