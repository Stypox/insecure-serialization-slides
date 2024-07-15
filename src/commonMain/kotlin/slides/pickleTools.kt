package slides

import LinkText
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import net.kodein.cup.Slide
import net.kodein.cup.utils.dataMapOf
import net.kodein.cup.widgets.material3.BulletPoints

val pickleTools by Slide(
    user = dataMapOf(
        SlideType.Normal(slideTitle = "Pickle - Tools")
    )
) {
    BulletPoints {
        BulletPoint {
            Row {
                LinkText("pickletools", "https://docs.python.org/3/library/pickletools.html")
                Text(" is a stdlib package for reading and inspecting pickles")
            }
        }
        BulletPoint {
            Row {
                LinkText("pickleassem", "https://pypi.org/project/pickleassem/")
                Text(" is a simple library for crafting pickles")
            }
        }
        BulletPoint {
            Row {
                LinkText("anapickle", "https://github.com/sensepost/anapickle")
                Text(" is a toolset for writing or injecting shellcode in pickles")
            }
        }
        BulletPoint {
            Row {
                LinkText("pwnypack.pickle", "https://github.com/edibledinos/pwnypack/blob/master/pwnypack/pickle.py")
                Text(" provides other useful tools")
            }
        }
    }
}
