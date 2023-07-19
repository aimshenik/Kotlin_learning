package com.imshenik.selfeducation.kata.solutions

import java.util.*

class Kata7 {
    //https://www.codewars.com/kata/550498447451fbbd7600041c/train/kotlin

    companion object {
        fun comp(a: IntArray?, b: IntArray?): Boolean =
            a?.map { it * it }?.toIntArray()?.sortedArray().contentEquals(b?.sortedArray())

        fun comp2(a: IntArray?, b: IntArray?) = if (a == null || b == null) false
        else a.sortedArrayDescending().asSequence()
            .zip(b.sortedArrayDescending().asSequence())
            .all { (a, b) -> (a * a) == b }
    }

}

fun main() {
    val a = intArrayOf(121, 144, 19, 161, 19, 144, 19, 11)
    val b = intArrayOf(11 * 11, 121 * 121, 144 * 144, 19 * 19, 161 * 161, 19 * 19, 144 * 144, 19 * 19)
    println(
        Arrays.toString(a.map { it * it }.toIntArray().sortedArray()) + "\n" +
                Arrays.toString(b.sortedArray())
    )
    println(a.map { it * it }.toIntArray().sortedArray().contentEquals(b.sortedArray()))
    println(a?.map { it * it }?.toIntArray()?.sortedArray()?.contentEquals(b?.sortedArray()) ?: false)
}