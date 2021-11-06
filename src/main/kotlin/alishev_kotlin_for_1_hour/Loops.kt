package alishev_kotlin_for_1_hour

fun main() {
    var items = listOf("apple", "banana", "orange") // = List.of() Java 9 - IMMUTABLE!!!
    mutableListOf("apple", "banana", "orange") //ArrayList - MUTABLE

    for (item in items)
        println(item)

    var index = 0
    while (index < items.size )
    {
        println("Item at index $index is ${items[index]}")
        index++
    }

    //DIAPOSONE as in Python 1..10
    println(5 in 1..10) //True - 'in' operator

    for (i in 0..100)
        println(i)

    for (i in 0 until 100) //EXCLUDE LAST VALUE //100
        println(i)

    for (i in 100 downTo 1)
        println(i)

    for (i in 0..100 step 10 ) //DIAPOSONE STEP
        println(i)
}