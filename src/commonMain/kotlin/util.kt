import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.sp
import net.kodein.cup.sa.SourceCode
import net.kodein.cup.sa.SourceCodeDebugColors
import net.kodein.cup.sa.SourceCodeTheme
import net.kodein.cup.sa.SourceCodeThemes

@Composable
fun Icon(
    imageVector: ImageVector,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
    tint: Color = LocalContentColor.current
) {
    androidx.compose.material3.Icon(imageVector, contentDescription, modifier, tint)
}

@Composable
fun DarkSourceCode(
    sourceCode: SourceCode,
    step: Int = 0,
    modifier: Modifier = Modifier,
    style: TextStyle = TextStyle(fontFamily = FontFamily.Monospace),
    theme: SourceCodeTheme = SourceCodeThemes.darcula,
    debug: SourceCodeDebugColors? = null
) {
    SourceCode(sourceCode, step, modifier, style.copy(fontSize = 9.sp), theme, debug)
}
