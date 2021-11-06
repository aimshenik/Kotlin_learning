package alishev_kotlin_for_1_hour

fun main() {
//    println(testSimple4( 100 ))
//    println(testNamedArguments(y=1,x=3,z=5)) // we can change order of arguments

//    testDefaultArguments()
//    testDefaultArguments(10)
//    testDefaultArguments(y=11)
//    testDefaultArguments(7,9)

    printEven(1,2,3,4,5,6,7,8,9,10)
    printEven(*intArrayOf(1,2,3,4,5,6,7,8,9),10,11,12) //Star-operator '*' is making vararg from array!!!
}


fun testSimple(): Int
{
    return 5+5
}

fun testSimple2(): Int = 5+5 //THE SAME AS ABOVE

fun testSimple3(x: Int, y: Int) = x+y //Return type not mandatory when it is obvious

fun testSimple4(x: Int): String {
    return "the value you provided is $x"//Return type not mandatory when it is obvious
}

fun testNamedArguments(x:Int, y:Int, z:Int): List<Int> {
    return listOf(x,y,z)
}

//default arguments (Java has no such feature)
//it is good alternative of
fun testDefaultArguments(x:Int = 1 , y: Int = 2){
    println(x+y)
}


//varargs
fun printEven(vararg numbers:Int){
     numbers.forEach {
         e -> if (e%2==0) println(e)
     }
}

