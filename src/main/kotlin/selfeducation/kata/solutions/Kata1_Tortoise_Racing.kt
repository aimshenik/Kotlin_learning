package com.imshenik.selfeducation.kata.solutions

import kotlin.math.abs

fun main() {

}

class Kata_Tortoise_Racing {
    //More generally: given two speeds v1 (A's speed, integer > 0) and v2 (B's speed, integer > 0) and a lead g (integer > 0) how long will it take B to catch A?
    //The result will be an array [hour, min, sec] which is the time needed in hours, minutes and seconds (round down to the nearest second) or a string in some languages.
    fun race(v1: Int, v2:Int, g:Int): IntArray{
        val time = g*3600/abs(v1-v2);
        return if (v1>=v2) intArrayOf(-1,-1,-1) else intArrayOf(time/3600,time/60%60,time%60)
    }
}

fun makePair(x: Int) = Pair(x%60, x/60)

fun race(v1:Int, v2:Int, g:Int) =
    if (v1 >= v2) intArrayOf()
    else generateSequence(makePair(60*60*g/(v2-v1))) { makePair(it.second) }
        .map { it.first }
        .take(3)
        .toList()
        .reversed()
        .toIntArray()

fun hi(x: Int) {
    generateSequence {  }
}