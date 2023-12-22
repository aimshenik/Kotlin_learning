package alishev_kotlin_for_1_hour


fun main() {
    foo()
    foo2()
    foo3()
    foo4()
}

fun foo() {
    listOf(1, 2, 3, 4, 5).forEach {
        if (it == 3) return@forEach // local return to the caller of the lambda - the forEach loop
        print(it)
    }
    println(" done with implicit label")
}

fun foo2() {
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit // local return to the caller of the lambda - the forEach loop
        print(it)
    }
    println(" done with implicit label")
}

fun foo3() {
    listOf(1, 2, 3, 4, 5).forEach(fun(value: Int) { //anonymous function
        if (value == 3) return  // local return to the caller of the anonymous function - the forEach loop
        print(value)
    })
    println(" done with anonymous function")
}

// There is no direct equivalent for break, but it can be simulated by adding another nesting
// lambda and non-locally returning from it:
fun foo4() {
    run loop@{
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return@loop // non-local return from the lambda passed to run
            print(it)
        }
    }
    print(" done with nested loop")
}