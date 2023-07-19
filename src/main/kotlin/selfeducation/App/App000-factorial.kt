package com.imshenik.selfeducation.App

fun main() {
    println("Hello, Andrey!")
    println("Look, fact(5) = ${fact(5)} ")

}

fun fact(i: Int): Long {
    return i * if (i==1) 1 else fact(i-1)
}

class App000 {

}