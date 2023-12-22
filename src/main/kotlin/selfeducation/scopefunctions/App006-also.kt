package selfeducation.scopefunctions

import kotlin.random.Random

//    also
//    The context object is available as an argument (it).
//    The return value is the object itself.

fun main() {
    val numbers = mutableListOf("one", "two", "three")
    numbers
        .also { println("The list elements before adding new one: $it") }
        .add("four")
    println(numbers) //[one, two, three, four]

    println("Random value : ${getRandom()}")
}

fun getRandom(): Int {
    return Random.nextInt().also { println("returned $it") }
}