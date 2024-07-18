package slides

import DarkSourceCode
import net.kodein.cup.PreparedSlide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.utils.dataMapOf

val phpExample by PreparedSlide(
    stepCount = 3,
    user = dataMapOf(
        SlideType.Normal(slideTitle = "PHP serialization - Example exploit")
    )
) {
    val sourceCode = rememberSourceCode("php") {
        val m1 by marker(hidden(0))
        val m2 by marker(hidden(0, 1))

        """
            class Joke {
                public ${'\$'}sourceFile;
                public function __construct(${'\$'}sourceFile) {
                    ${'\$'}this->sourceFile = ${'\$'}sourceFile;
                }
                public function __toString() {
                    return file_get_contents(${'\$'}this->sourceFile);
                }
            }
            ${'\$'}jokes = [new Joke("joke1.txt"), new Joke("joke2.txt"), /* ... */];
            $m1
            // ... meanwhile in another part of the codebase:
            ${'\$'}userName = unserialize(${'\$'}data)
            echo "Welcome" . ${'\$'}userName
            $X$m2
            // instead of passing a Person, we could forge:
            // O:4:"Joke":1:{s:10:"sourceFile";s:8:"flag.txt";}
            // and get the file contents of "flag.txt"
            $X
        """.trimIndent()
    }

    slideContent { step ->
        DarkSourceCode(sourceCode, step = step)
    }
}
