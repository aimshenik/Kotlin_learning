package selfeducation.multithreading

import java.lang.Thread.sleep
import java.util.concurrent.Callable
import java.util.concurrent.LinkedBlockingQueue
import java.util.concurrent.RejectedExecutionHandler
import java.util.concurrent.SynchronousQueue
import java.util.concurrent.ThreadPoolExecutor
import java.util.concurrent.TimeUnit

//на этой лекции разбираем ThreadPoolExecutor
//https://www.youtube.com/watch?v=nU3Yf8UVWVc&list=PLyxk-1FCKqodhV1d55ZmoAcz6aeyhLxnr&index=28

//    corePoolSize - кол-во готовых к запуску тредов
//    maximumPoolSize - max кол-во тредов
//    keepAliveTime - сколько времени хранить неиспользуемые потоки
//    unit - в чём измеряется keepAliveTime
//    workQueue - очередь входящих задач
//    handler - RejectExecutionHandler - интерфейс
fun main() {
    val es = ThreadPoolExecutor(
        3,
        6,
        1,
        TimeUnit.MILLISECONDS,
        LinkedBlockingQueue(2), //максимум 2 задачи в очереди на ожидание
        MyReject()
    )

    for (i in 1..9) {
        val callable = MyCallable10()
        es.submit(callable)
    }
//Принцип действия : 3 задачи попадают на corePool-потоки, 2 задачи попадают в очередь LinkedBlockingQueue()
//Если задачу нельзя поставить в очередь, её передают на следующий поток из maximumPoolSize



    val ess = ThreadPoolExecutor(
        3,
        6,
        1,
        TimeUnit.MILLISECONDS,
        SynchronousQueue(), //это очередь в которую ничего нельзя поставить (capacity=0)
        MyReject()
    )
}

class MyCallable10 : Callable<Long> {
    override fun call(): Long {
        println("Start: ${Thread.currentThread().id}")
        sleep(1000)
        println("End: ${Thread.currentThread().id}")
        return Thread.currentThread().id
    }
}

class MyReject : RejectedExecutionHandler {
    override fun rejectedExecution(r: Runnable?, executor: ThreadPoolExecutor?) {
        println("SOME RUNNABLE BEEN REJECTED!!!")
    }
}