package selfeducation.scopefunctions

import java.io.BufferedReader
import java.io.InputStreamReader
import java.nio.charset.StandardCharsets.UTF_8

fun main() {
// run does the same as with but it is implemented as an extension function.
// So like let, you can call it on the context object using dot notation.

//run is useful when your lambda both initializes objects and computes the return value.
    val service = MultiportService("https://example.kotlinlang.org", 80)

    val result = service.run {
        port = 8080
        query(prepareRequest() + " to port $port") //возвращаемое значение
    }

    println(result)

    val process = Runtime.getRuntime().exec("ping 8.8.8.8")
    val stdInput = BufferedReader(InputStreamReader(process.inputStream, UTF_8))
    for (l in stdInput.lines()) {
        println(l)
    }
}

class MultiportService(var address: String, var port: Int){
    fun query(fqdn: String) = "Calling request $fqdn"
    fun prepareRequest() = "$address:$port"
}