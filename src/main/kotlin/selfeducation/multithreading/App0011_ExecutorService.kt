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

    var tasks = mutableListOf<Future<Long>>()

    for (i in 0 until 3) {
        val callable = MyCallable3()
        tasks.add(es.submit(callable)) //получает фьючу
    }

    for (f in tasks){
        f.get() //дожидаемся окончания всех задач которые мы запустили
    }

    es.shutdown()
}

class MyCallable3 : Callable<Long> {
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
