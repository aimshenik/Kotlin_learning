package alishev_kotlin_for_1_hour

fun main() {
//AAAABBBVCCDDDEEEEMMMMMMMM -> A4B3V1C2D3E4M8
    val strInput = "AAAABBBVCCDDDEEEEMMMMMMMM"
    val strResult = "A4B3V1C2D3E4M8"
    if (charCount2(strInput) == strResult)
        println("CORRECT")
    else println("WRONG")
}

fun charCount(input: String): String {
    var result = ""
    val singleCHars = input.split("(?<=([A-z]))(?!\\1)(?!\$)".toRegex())
    println(singleCHars)
    for (arr in singleCHars)
    {
            result += arr.get(0) + arr.length.toString()
            println(arr)
    }
    println("res = $result")
    return result
}

fun charCount2(input: String) : String{
    return input.split("(?<=([A-z]))(?!\\1)(?!\$)".toRegex())
        .map { el ->  el.get(0) + el.length.toString() }
        .reduce{acc , e -> acc + e}
}