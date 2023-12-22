package selfeducation.multithreading

import java.lang.Thread.sleep
import java.util.concurrent.Executors

fun main() {
    val es = Executors.newCachedThreadPool()
    val future = es.submit(MyRunnable())

    do {
        println("job in progress...")
        sleep(500)
    }
    while (future.isDone.not())

    future.get() //блокирующая. ожидает завершения выполнения таски

    println("job is done!")
}

class MyRunnable : Runnable{
    override fun run() {
        println("Started: ${Thread.currentThread().id}")
        sleep(5000)
        println("Finished: ${Thread.currentThread().id}")
    }
}
