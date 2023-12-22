package selfeducation.scopefunctions

import kotlin.random.Random

//it ~ In turn, 'let' and 'also' reference the context object as a lambda argument.
// If the argument name is not specified, the object is accessed by the implicit default name it.
// it is shorter than this and expressions with it are usually easier to read.

fun main() {
    fun getRandomInt(): Int {
        return Random.nextInt(100).also {
            println("getRandomInt() generated value $it")
        }
    }

    val i = getRandomInt()
    println(i)
}

