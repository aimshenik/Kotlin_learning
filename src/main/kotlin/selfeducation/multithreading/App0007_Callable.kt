package selfeducation.multithreading

import java.math.BigInteger
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future

//https://www.baeldung.com/java-return-value-after-thread-finish

class App0007_Callable {
    fun execute(tasks: List<CallableFactorialTask>): BigInteger {
        var result = BigInteger.ZERO
        val cachedPool = Executors.newCachedThreadPool()
        var futures: List<Future<BigInteger>> = emptyList()
        try {
            futures = cachedPool.invokeAll(tasks)
        } catch (e: InterruptedException) {
        }

        for (future in futures) {
            try {
                result = result.add(future.get())
            } catch (e: InterruptedException) {
            }
        }
        return result
    }

}

fun main() {
    val tasks = mutableListOf(
        CallableFactorialTask(BigInteger.valueOf(5)),
//        CallableFactorialTask(BigInteger.valueOf(4)),
        CallableFactorialTask(BigInteger.valueOf(3))
    )

    val result = App0007_Callable().execute(tasks)
    println(result)
}

class CallableFactorialTask(val x: BigInteger) : Callable<BigInteger> {
    override fun call(): BigInteger = FactorialCalculator().factorial(x)
}

class FactorialCalculator {

    fun factorial(end: BigInteger): BigInteger {
        val start = BigInteger.ONE
        var res = BigInteger.ONE

        for (i in 1L..end.toLong()) {
            res = res.multiply(BigInteger.valueOf(i))
        }
        return res
    }

    fun factorial(start: BigInteger, end: BigInteger): BigInteger {
        var res = start

        for (i in 1L..end.toLong()) {
            res = res.multiply(BigInteger.valueOf(i))
        }
        return res
    }
}