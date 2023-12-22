package selfeducation.App

fun main() {
    val str = "InstrumentServiceImplPG"

    str.toByteArray().forEach { print(it) }

    str.let { println(it) }

    val a : A = AB()
    println(a.javaClass)
}

interface A

class AA : A
class AB : A