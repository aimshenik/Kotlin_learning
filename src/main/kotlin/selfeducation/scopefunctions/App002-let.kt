package selfeducation.scopefunctions

// Function = let
// Object reference = it
// Return value = Lambda result
// Is extension function = Yes

fun main() {
    var str = "BBB"
    //let - без неё пришлось бы заводить новую переменную для ААА
    "AAA".let {
        println("it = $it")
        str += it.first()
    }
    println("str = $str")
}
