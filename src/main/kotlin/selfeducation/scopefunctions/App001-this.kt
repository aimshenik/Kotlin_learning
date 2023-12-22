package selfeducation.scopefunctions

//this ~ 'run', 'with', and 'apply' reference the context object as a lambda receiver - by keyword this.
// Hence, in their lambdas, the object is available as it would be in ordinary class functions.

fun main() {
    val adam = Person(name = "Adam").apply {
        age = 20                       // same as this.age = 20
        city = "London"
    }
    println(adam)
}

data class Person(var age: Int = 0, var name: String, var city: String = "")