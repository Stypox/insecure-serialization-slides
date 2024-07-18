package slides

import LinkText
import SlideType
import net.kodein.cup.Slide
import net.kodein.cup.utils.dataMapOf
import net.kodein.cup.widgets.material3.BulletPoints

val writeups by Slide(
    user = dataMapOf(
        SlideType.Normal(slideTitle = "Writeups")
    )
) {
    BulletPoints {
        BulletPoint {
            LinkText("Python pickle, simple", "https://ctftime.org/writeup/36628")
        }
        BulletPoint {
            LinkText("Python pickle, with some checks", "https://ctftime.org/writeup/16723")
        }
        BulletPoint {
            LinkText("Python pickle, reversing a pickle file", "https://blog.efiens.com/post/frost/redpwn-ctf-writeup/")
        }
        BulletPoint {
            LinkText("Python pickle, reversing a buggy implementation, DEFCON Quals", "https://blog.washi.dev/posts/defcon-brinebid/")
        }
        BulletPoint {
            LinkText("Java Object Serialization, with some checks", "https://ctftime.org/writeup/12656")
        }
        BulletPoint {
            LinkText("Java Object Serialization, with gadget chains", "https://ctftime.org/writeup/25670")
        }
        BulletPoint {
            LinkText("PHP serialization, simple", "https://trevorsaudi.medium.com/cybertalents-weekend-ctf-gu55y-writeup-php-object-injection-dfe173d9f446")
        }
    }
}
