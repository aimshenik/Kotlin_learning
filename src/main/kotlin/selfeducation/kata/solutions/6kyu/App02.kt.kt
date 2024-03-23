package selfeducation.kata.solutions.`6kyu`

import javax.xml.stream.events.Characters

fun main() {
//    println(JavaUnicodeEncoder.encode("hola"))
//    JavaUnicodeEncoder.decode("\\u0068\\u006f\\u006c\\u0061")

//    println("%04x".format(15))
    println("%X".format(15))
}

object JavaUnicodeEncoder {

    fun decode(input: String?): String {
        if ((input?.length ?: 0) % 6 != 0) return ""
        var result = ""
        (0 until (input?.length ?: 0) step 6).forEach{
            val letter = input?.substring(it,it+6)
            println(letter)
            result+= letter?.removePrefix("\\u")?.toInt(radix = 16)?.toChar() ?: ""

        }
        return result
    }

    fun encode(input: String?): String =
        input?.toCharArray()?.map {
            var suffix = "\\u"
            val hexStr = Integer.toHexString(it.code)
            (0 until 4 - hexStr.length).forEach { _ -> suffix += "0" }
            "$suffix$hexStr"
        }?.joinToString(separator = "") ?: ""

    fun decode2(input:String?):String = input!!.split("\\u").drop(1).map{it.toInt(16).toChar()}.joinToString("")
    fun encode2(input:String?):String = input!!.map{"\\u%04x".format(it.toInt())}.joinToString("")

    fun decode3(input: String?): String {
        return input!!.split(Regex("\\\\u")).filter { it.isNotEmpty() }.map { it.toInt(16).toChar() }.joinToString("")
    }

    fun encode3(input: String?): String {
        return input!!.map { char -> "\\u".plus(Integer.toHexString(char.toInt()).padStart(4, '0')) }.joinToString("")
    }
}

//padStart
//drop
//toInt(16)
//"\\u%04x".format(it.toInt())