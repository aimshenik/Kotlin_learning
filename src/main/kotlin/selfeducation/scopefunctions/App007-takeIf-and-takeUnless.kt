package selfeducation.scopefunctions

import kotlin.random.Random

//In addition to scope functions, the standard library contains the functions takeIf and takeUnless.
//These functions let you embed checks of an object's state in call chains.

//takeIf
//When called on an object along with a predicate, takeIf returns this object if it satisfies the given predicate.
//Otherwise, it returns null. So, takeIf is a filtering function for a single object.

//takeUnless
//takeUnless has the opposite logic of takeIf. When called on an object along with a predicate,
// takeUnless returns null if it satisfies the given predicate. Otherwise, it returns the object.

//When using takeIf or takeUnless, the object is available as a lambda argument (it).

fun main() {
    val number = Random.nextInt(100)

    val evenOrNull = number.takeIf { it % 2 == 0 }
    val oddOrNull = number.takeUnless { it % 2 == 0 }
    println("even: $evenOrNull, odd: $oddOrNull")
}