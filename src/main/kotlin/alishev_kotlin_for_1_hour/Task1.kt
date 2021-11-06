package alishev_kotlin_for_1_hour

fun main() {
    val array1 = arrayOf(1, 1, 2, 3, 4, 5, 6, 3, 4, 5, 6, 3, 4, 5)
    val array2 = arrayOf(5, 5, 6, 6, 1, 2, 2, 2, 3, 3, 1, 1, 1, 1, 1, 1)
    var array3 = emptyArray<Int>()
    var result = emptyArray<Int>()
//    println("1:${array1.get} 2: 3: ")
    var counter = 0
    for (it in array1) {
        if (it in array2)
            for (i in 0 until array2.size) {
                if (it == array2[i] && i !in array3) {
                    array3 = array3.plus(i)
                    result = result.plus(it)
                    break
                }
            }
    }
    array3.forEach { it -> print("$it ") }
    println()
    result.forEach { it -> print("$it ") }
    println()

    var newResult = ArrayList<Int>()
    for (el in array1) {
        if (array2.contains(el)) {
            val numOfRepeats = minOf(array1.count { it == el }, array2.count { it == el })
            if (el !in newResult) repeat(numOfRepeats) { newResult.add(el) }
        }
    }
    newResult.forEach { it -> print("$it ") }


}