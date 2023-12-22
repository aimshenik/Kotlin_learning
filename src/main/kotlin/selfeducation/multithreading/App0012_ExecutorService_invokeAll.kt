package selfeducation.multithreading

import java.lang.Thread.sleep
import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.Future
import kotlin.random.Random

//на этой лекции разбираем ExecutorService
//https://www.youtube.com/watch?v=GtHe_wzJsWo&list=PLyxk-1FCKqodhV1d55ZmoAcz6aeyhLxnr&index=27
fun main() {
    val es = Executors.newFixedThreadPool(10) //создаётся в самом начале приложения

    var tasks = mutableListOf<Callable<Long>>()

    for (i in 0 until 3) {
        val callable = MyCallable4()
        tasks.add(callable) //получает фьючу
    }

    val futureList: List<Future<Long>> = es.invokeAll(tasks) //invokeAll синхронный,
    //ждём пока все задачи не завершатся. Во фьючах уже будет ответ.

    futureList.forEach { println(it.get()) }

    println("FINISH")
    es.shutdown()
}

class MyCallable4 : Callable<Long> {
    override fun call(): Long {
        try {
            println("Started: ${Thread.currentThread().id}")
            sleep(1000 + Random.nextLong(5000L))
            println("Finished: ${Thread.currentThread().id}")
        } catch (e: Exception) {
            e.printStackTrace(System.out)
        }
        return Thread.currentThread().id
    }
}
