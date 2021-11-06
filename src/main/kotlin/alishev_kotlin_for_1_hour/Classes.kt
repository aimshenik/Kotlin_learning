package alishev_kotlin_for_1_hour

fun main() {
    val child = Person("Child", "Child", 1)
    val p1 = Person("ANDREY", "IMSHENIK", 35, child)
    println(p1.children[0].firstName) // Child

    val p2 = Person()
    println(p2.age) // -1


    val rect1 = Rectangle(5.0, 2.0)
    val rect2 = Rectangle(5.0, 2.0)
    println(rect1==rect2) //TRUE because comparisiom by value
 }


class Person (val firstName: String, val lastName: String, var age: Int){  //Primary constructor //this fields HAVE getter/setter by default
    var children: MutableList<Person> = mutableListOf() //array

    init { //init block //runs after construction
        println("Person is created ${firstName}")
    }

    constructor(firstName: String, lastName: String, age: Int, child: Person):
            this(firstName,lastName,age){ //MANDATORY TO CALL PRIMARY CONSTRUCTOR FROM SECONDARY CONSTRUCTOR
            children.add(child)
    }

    constructor() : this("","", -1 ) //constructor with default values
}


//'data' - metaword for data-classes to auto-implement hashCode, toString, equals
data class Rectangle(var h: Double, var l: Double){
    var perimetr = 2*(h+l)

    //MAKING OWN GETTER AND SETTER
    var test=1
        get() = field + 1 // 'field' = this.test //{} could be omitted in case of single expression
        set(value){
            if (value < 0) println("Negative value")
            field = value
        }

    fun area() = h * l //this is class method with one-line
}