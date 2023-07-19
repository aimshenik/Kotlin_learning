package com.imshenik.selfeducation.kata.solutions

import kotlin.math.abs

fun main() {

}

class Kata_Rectangle {
//    You are given the length and width of a 4-sided polygon. The polygon can either be a rectangle or a square.
//    If it is a square, return its area. If it is a rectangle, return its perimeter.
//
//    area_or_perimeter(6, 10) --> 32
//    area_or_perimeter(3, 3) --> 9
//    Note: for the purposes of this kata you will assume that it is a square if its length and width are equal, otherwise it is a rectangle.


    fun areaOrPerimeter(l: Int, w: Int): Int = if (l == w) w * l else 2 * (w + l)
}

