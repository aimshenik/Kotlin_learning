package selfeducation.scopefunctions

// Function = with
// Object reference = this
// Return value = Lambda result
// Is extension function = No: takes the context object as an argument.


fun main() {
    //with - это доступ к объекту через this. Причем свойства объекта доступны без 'this'
    val numbers = mutableListOf("one", "two", "three")
    with(numbers) { //не EXTENSION поэтому надо передать объект для THIS
        println("'with' is called with argument $this")
        println("It contains $size elements")
    }
    with("ASDASDASDASDASDASDASD"){
        println(length)
        println(this.length)
        println(lowercase())
    }
    val firstAndLast = with(numbers) {
        "The first element is ${first()}," +
                " the last element is ${last()}"
    }
    println("firstAndLast = $firstAndLast")
}