package selfeducation.multithreading

import java.lang.Thread.sleep
import java.util.concurrent.Callable
import java.util.concurrent.Executors

fun main() {
    val es = Executors.newCachedThreadPool()
    val future = es.submit(MyCallable2())

    sleep(1000)

    future.cancel(true) //попробовать остановить задачу
//    поскольку поток не спал, команда cancel не сработает и Finished выведется в консоли.

    println("job is done!")
}

class MyCallable2 : Callable<Int>{
    override fun call() : Int{
        println("Started: ${Thread.currentThread().id}")
        sleep(1)
        val d = System.currentTimeMillis()
        do {

        }while (System.currentTimeMillis() - d < 5000)
        println("Finished: ${Thread.currentThread().id}")
        return 100
    }
}
