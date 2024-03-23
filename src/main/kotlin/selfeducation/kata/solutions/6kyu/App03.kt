package selfeducation.kata.solutions.`6kyu`

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test


//https://www.codewars.com/kata/54bf1c2cd5b56cc47f0007a1/train/kotlin


fun main() {

}




class App03 {


    @Test
    fun `abcde returns zero`() {
        assertEquals(0, duplicateCount("abcde"))
    }

    @Test
    fun `abcdea returns one`() {
        assertEquals(1, duplicateCount("abcdea"))
    }

    @Test
    fun `indivisibility returns one`() {
        assertEquals(1, duplicateCount("indivisibility"))
    }

    @Test
    fun `really long string containing duplicates returns three`() {
        val text = "dA" + "c".repeat(10) + "b".repeat(100) + "a".repeat(1000)
        assertEquals(3, duplicateCount(text))
    }
}


fun duplicateCount(text: String): Int {
    return text.lowercase().groupBy { it }.filterValues { it.size > 1 }.size
}

fun duplicateCount2(text: String) = text.groupBy(Char::toLowerCase).count { it.value.count() > 1 }