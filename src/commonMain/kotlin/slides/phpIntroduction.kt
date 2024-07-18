package slides

import DarkSourceCode
import net.kodein.cup.PreparedSlide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.utils.dataMapOf

val phpIntroduction by PreparedSlide(
    stepCount = 3,
    user = dataMapOf(
        SlideType.Normal(slideTitle = "PHP serialization - Introduction")
    )
) {
    val sourceCode = rememberSourceCode("php") {
        val m1 by marker(highlighted(1))
        val m2 by marker(highlighted(2))

        """
            class Person {
              public ${'\$'}name = "John";
              public ${'\$'}age = 34;
            }
            
            ${'\$'}person = new Person();
            ${'\$'}data = ${m1}serialize(${'\$'}person)$X;
            echo ${'\$'}data . "\n";
            // ${m2}O:6:"Person":2:{s:4:"name";s:4:"John";s:3:"age";i:34;}$X
            
            ${'\$'}person2 = ${m1}unserialize(${'\$'}data)$X;
            echo ${'\$'}person2->name . "\n";
        """.trimIndent()
    }

    slideContent { step ->
        DarkSourceCode(sourceCode, step = step)
    }
}
