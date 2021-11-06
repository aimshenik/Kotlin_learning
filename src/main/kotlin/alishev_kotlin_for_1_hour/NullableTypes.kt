package alishev_kotlin_for_1_hour

fun main() {
    var a : String = ""
//    a = null // Compilation error : IMPOSSIBLE to put null in 'a'
    println(a.length) // Compiler let us call .length because 'a' 100% not null

    var b : String? = "test"
    b = null // null appliable to '?'-marked types
//    b.length // Compiler error -> only Safe-Calls approved for nullable types
    b?.length //Safe-Call. !!! in case of b==null it will return null, not NPE here!!!

    // ELVIS-operator (:?) let us get particulr value in case of b==null
    val l = b?.length ?: -1

    // !!-operator - it throws NPE in case of b==null
    b = if ((0..10).random()>5) "qwe" else null
    val t = b!!.length
}


