package alishev_kotlin_for_1_hour

fun main() {
    val data = arrayListOf("eat","tea","leed","deel","elde","sse","ess","ses","Andrey","ndreyA","Areydn")
    println(listGrouper(data))
}

fun listGrouper(input:List<String>) : List<List<String>>{
    return input
        .groupBy(keySelector = { it.toCharArray().sorted() }, valueTransform = { it }   )
        .map { it.value }
}
