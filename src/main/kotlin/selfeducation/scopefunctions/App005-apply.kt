package selfeducation.scopefunctions

//apply
//The context object is available as a receiver (this).
//The return value is the object itself.

fun main() {
    val adam = Person(name = "Adam").apply {
        age = 32
        city = "London"
    }
    println(adam)
}