package selfeducation.multithreading

import java.lang.Thread.sleep
import java.util.concurrent.Callable
import java.util.concurrent.Executors

fun main() {
    val es = Executors.newCachedThreadPool()
    val future = es.submit(MyCallable())

    do {
        println("job in progress...")
        sleep(500)
    }
    while (future.isDone.not())

    val res = future.get() //get() - блокирующий метод, ожидает завершения выполнения таски

    println("job is done, res : $res")
}

class MyCallable : Callable<Int>{
    override fun call() : Int{
        println("Started: ${Thread.currentThread().id}")
        sleep(5000)
        println("Finished: ${Thread.currentThread().id}")
        return 100
    }
}
