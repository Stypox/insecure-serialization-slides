package slides

import DarkSourceCode
import net.kodein.cup.PreparedSlide
import net.kodein.cup.sa.rememberSourceCode
import net.kodein.cup.utils.dataMapOf

val phpIntroduction by PreparedSlide(
    stepCount = 5,
    user = dataMapOf(
        SlideType.Normal(slideTitle = "Java Object Serialization - Introduction")
    )
) {
    val sourceCode = rememberSourceCode("java") {
        val m1 by marker(highlighted(1))
        val m2 by marker(highlighted(2))
        val m3 by marker(highlighted(3))
        val m4 by marker(highlighted(4))

        """
            class Person implements Serializable {
                ${m3}static final long serialVersionUID = 42L;${X}
                String name;
                int age;
                Person(String name, int age) {
                    this.name = name;
                    this.age = age;
                }
            }

            var person = new Person("John", 34);
            
            var bos = new ByteArrayOutputStream();
            ${m1}var oos = new ObjectOutputStream(bos);
            oos.writeObject(person);${X}
            // bos contains b'${m4}\xac\xed${X}\x00\x05sr\x00\x16${m2}REPL.${'$'}JShell${'$'}17${'$'}Person${X}${m3}\x00\x00\x00\x00\x00\x00\x00*${X}
            // \x02\x00\x02I\x00\x03${m2}age${X}L\x00\x04${m2}name${X}t\x00\x12${m2}Ljava/lang/String${X};xp\x00\x00\x00${m2}"${X}t\x00\x04${m2}John${X}'
            
            var bis = new ByteArrayInputStream(new byte[] { -84, -19, 0, 5, 115, /* ... */ });
            ${m1}var ois = new ObjectInputStream(bis);
            ois.readObject(person);${X}
        """.trimIndent()
    }

    slideContent { step ->
        DarkSourceCode(sourceCode, step = step)
    }
}
