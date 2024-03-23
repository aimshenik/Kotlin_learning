package selfeducation.App

fun main() {
    val str = "InstrumentServiceImplPG"

    str.toByteArray().forEach { print("$it.") }.also { println() }

    with(str) { println(this) }

    val a : A = AB()
    println(a.javaClass)
}

interface A

class AA : A
class AB : A