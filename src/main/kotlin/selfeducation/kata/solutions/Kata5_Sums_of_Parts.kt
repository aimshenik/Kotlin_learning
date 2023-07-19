package com.imshenik.selfeducation.kata.solutions

import java.util.*

class Kata5_Sums_of_Parts {
}

fun main() {
    println(Arrays.toString(sumParts(intArrayOf(1, 2, 3, 4, 5, 6))))
    println(Arrays.toString(sumParts(intArrayOf(744125, 935, 407, 454, 430, 90, 144, 6710213, 889, 810, 2579358))))
}

fun sumParts(ls: IntArray): IntArray {
    var res = ls.plus(0);
    for (i in res.size - 2 downTo 0) {
        res[i] += res[i + 1]
    }
    return res
}

fun sumParts2(ls: IntArray) = ls.foldRightIndexed(IntArray(ls.size + 1)) { i, n, acc -> acc[i] = acc[i + 1] + n; acc }

fun sumParts3(ls: IntArray) = IntArray(ls.size + 1).apply {
    set(0, ls.sum())
    ls.forEachIndexed { index, item -> set(index + 1, get(index) - item) }
}