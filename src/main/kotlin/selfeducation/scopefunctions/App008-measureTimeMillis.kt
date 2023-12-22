package selfeducation.scopefunctions

import kotlin.system.measureTimeMillis

fun main() {
    val numbers: List<Int>
    val timeInMillis = measureTimeMillis {
        numbers = buildList {
            addAll(0..100)
            shuffle()
            sortDescending()
        }
    }
// here numbers are initialized and sorted
    println(numbers.first()) // 100

    println("(The operation took $timeInMillis ms)")
}