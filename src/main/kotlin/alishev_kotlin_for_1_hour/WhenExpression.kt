package alishev_kotlin_for_1_hour

fun main() {
    testWhen(1)
    testWhen("ASD")
    testWhen(1..13)
}

fun testWhen(input: Any){
    when (input) {
        1 -> println("One")
        2 -> println("Two")
        in 10..15 -> print("from 10 to 15")
        is String -> print("String entered of length ${input.length}")
        else -> print("input is Something else")
    }
}