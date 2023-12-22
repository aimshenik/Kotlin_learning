package selfeducation.multithreading

import java.util.concurrent.Callable
import java.util.concurrent.Executors

//на этой лекции разбираем ExecutorService
//https://www.youtube.com/watch?v=GtHe_wzJsWo&list=PLyxk-1FCKqodhV1d55ZmoAcz6aeyhLxnr&index=27
fun main() {
    val es = Executors.newFixedThreadPool(10) //создаётся в самом начале приложения

    var tasks = mutableListOf<Callable<Long>>()

    for (i in 0 until 3) {
        val callable = MyCallable4()
        tasks.add(callable) //получает фьючу
    }

    val future: Long = es.invokeAny(tasks) //invokeAny синхронный для первой выполненной задачи,
//    на остальных потоках неявно вызовется Cancel, что может привести к InterruptedException

    println(future)

    println("FINISH")
    es.shutdown()
}
