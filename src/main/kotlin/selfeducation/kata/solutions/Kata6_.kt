package com.imshenik.selfeducation.kata.solutions

import kotlin.math.pow

class Kata6_ {
    companion object {
        @ExperimentalStdlibApi
        fun toCamelCase(s: String): String = s.replace(Regex("(_|-)(\\w)"), { it.groupValues[2].uppercase() })
//            s.split("[_-]".toRegex())
////            .mapIndexed { idx, c -> if (idx != 0) c.replaceFirstChar { it.toUpperCase() } else c }
//            .reduce{acc , e -> acc + e.capitalize()}
    }
}

@OptIn(ExperimentalStdlibApi::class)
fun main() {
    println("The-Stealth-Warrior".split("[_-]".toRegex()))

    println("the-stealth-warrior".split("[_-]".toRegex())
        .mapIndexed { idx, c -> if (idx != 0) c.replaceFirstChar { it.toUpperCase() } else c }
        .reduce{acc , e -> acc + e})

    println("my-name-is_andrey".split("[_-]".toRegex())
        .reduce{acc , e -> acc + e.capitalize()})

    println(listOf("a", "b", "c", "d").reduce { acc, s -> acc + s.capitalize()})

    println("my-name-is_andrey".replace(Regex("(_|-)(\\W+)?[\\w]"), { it.value.substring(1).uppercase() }))
    println("my-name-is_andrey".replace(Regex("(_|-)(\\w)"), { it.groupValues[2].uppercase() }))
}