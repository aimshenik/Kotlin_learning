package com.imshenik.selfeducation.kata

import kotlin.math.pow

fun main() {
    println(digPow(89, 1) == 1)
    println(digPow(92, 1) == -1)
    println(digPow(695, 2) == 2)
    println(digPow(46288, 3) == 51)
}

fun digPow(n: Int, p: Int): Int {
    var k = p
    val sum  = "$n"
        .toCharArray()
        .map { Integer.parseInt(it.toString()).toDouble().pow(k++).toInt() }
        .sum()
    return if (sum%n == 0)  sum/n else  -1
}

fun digPow2(n: Int, p: Int) =
    n.toString()
        .mapIndexed { i, c -> c.toString().toDouble().pow(p + i).toInt() }
        .sum()
        .let { if (it % n == 0) it / n else -1 }
