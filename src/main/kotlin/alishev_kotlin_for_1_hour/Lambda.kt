package alishev_kotlin_for_1_hour

fun main() {
    val a = listOf(1,2,3,4,5)

    //FOREACH
    a.forEach{ e -> print(" ${e}")}
    //MAP
    a.map { e -> e*2 }.forEach{ e -> print(" ${e}")}
    //FILTER
    a.filter { e -> e%2==0 }.forEach{ e -> print(" ${e}")}
    //REDUCE
    println(a.reduce{sum, e -> sum + e}) //sum()
    //SORT
    a.sortedByDescending { it }
    //ANY    //convention to call variable 'it' in case of collection iteration
    a.any{it > 10} //true if any of elements > 10
    //ALL
    a.all {it < 10 } //true because all elements < 10
    //SUM
    a.sum() // sum of all
    //PARTITION
    val numbers = listOf(1,3,-4,2,-11)
    val (positive, negative) = numbers.partition { it > 0  } //'partition is dividing list into 2 collection by some rule
    println(positive)
    //GROUP BY
    val asd = listOf<String>("a","b","ba", "ccc", "ad").groupBy { it.length } //in result we will have HashMap {1=[a, b], 2=[ba, ad], 3=[ccc]}
    println(asd)
}

