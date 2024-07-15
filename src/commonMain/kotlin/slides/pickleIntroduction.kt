package slides

import DarkSourceCode
import net.kodein.cup.PreparedSlide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.utils.dataMapOf

val pickleIntroduction by PreparedSlide(
    stepCount = 3,
    user = dataMapOf(
        SlideType.Normal(slideTitle = "Pickle - Introduction")
    )
) {
    val sourceCode = rememberSourceCode("python") {
        val m1 by marker(highlighted(1))
        val m2 by marker(highlighted(2))

        """
            import pickle
            
            class Person:
                def __init__(self, name, age):
                    self.name = name
                    self.age = age

            person = Person("John", 34)

            print(${m1}pickle.dumps(person)${X})
            # b'\x80\x04 ... \x8c\x06${m2}Person${X} ... \x8c\x04${m2}name${X}\x94\x8c\x04${m2}John${X}\x94\x8c\x03${m2}age${X}\x94K${m2}"${X}ub.'

            print(${m1}pickle.loads(b'\x80\x04 ... ')${X})
            # Person(name=John, age=34)
        """.trimIndent()
    }

    slideContent { step ->
        DarkSourceCode(sourceCode, step = step)
    }
}
