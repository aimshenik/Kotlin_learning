package selfeducation.kata.solutions.`5kyu`

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.lang.Math.max

//https://www.codewars.com/kata/54521e9ec8e60bc4de000d6c/train/kotlin

//The maximum sum subarray problem consists in finding the maximum sum of a contiguous subsequence in an array or list of integers:
//
//maxSequence(listOf(-2, 1, -3, 4, -1, 2, 1, -5, 4));
//// should be 6: listOf(4, -1, 2, 1)
//Easy case is when the list is made up of only positive numbers and the maximum sum is the sum of the whole array. If the list is made up of only negative numbers, return 0 instead.
//
//Empty list is considered to have zero greatest sum. Note that the empty list or array is also a valid sublist/subarray.
fun main() {


}

class App01 {
    @Test
    fun `it should work on an empty list`() {
        assertEquals(0, maxSequence(emptyList()))
    }

    @Test
    fun `it should work on the example`() {
        assertEquals(6, maxSequence(listOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
    }
}

fun maxSequence(arr: List<Int>) =
    if (arr.isEmpty()) 0
    else {
        var res = 0
        val a0 = arr.toTypedArray()
        for (i in a0.indices) {
            for (j in a0.indices) {
                res = maxOf(res, a0.slice(i..j).sum())
            }
        }
        res
    }

fun maxSequence2(arr: List<Int>): Int {
    var max = 0
    arr.indices.forEach { outer ->
        (outer..arr.size).forEach { inner ->
            max = max(arr.subList(outer, inner).sum(), max)
        }
    }
    return max
}