package com.imshenik.selfeducation.kata

import kotlin.math.abs

fun main() {
    duplicateCount2("indivisibility")
}

fun duplicateCount2(text: String): Int = text.toUpperCase().groupBy{it}.filter { it.value.size > 1 }.count()

fun duplicateCount(text: String) = text.groupBy(Char::toLowerCase).count { it.value.count() > 1 }
