package selfeducation.kata.solutions.`6kyu`

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

//https://www.codewars.com/kata/514b92a657cdc65150000006/train/kotlin
fun main() {
    println(solution(10))
    println(solution(20))
    println(solution(200))
}

fun solution(number: Int) = when (number <= 0) {
    true -> 0
    else -> (1 until number).filter { it % 3 == 0 || it % 5 == 0 }.sum()
}


class App01 {
    @Test
    fun testFixed() {
        assertEquals(23, solution(10))
        assertEquals(78, solution(20))
        assertEquals(9168, solution(200))
    }
}