package com.imshenik

import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

fun main() {
    val executorService: ExecutorService = Executors.newFixedThreadPool(5)
//    val executorService: ExecutorService = Executors.newCachedThreadPool() // - newCachedThreadPool() сам решает сколько надо создать потоков


    class MyThread(val nameZ: String) : Thread() {
        val lock = ReentrantLock()
        override fun run() {
            lock.withLock {
                for (i in 1..10) {
                    sleep(10)
                    println("${Thread.currentThread().name} - $i : $nameZ")
                }
            }
        }
    }

    val mt = MyThread("EXAMPLE")

    for (i in 1..10) {
        executorService.execute(mt)
//        executorService.execute(MyThread("A"))
//        executorService.execute(MyThread("B"))
//        executorService.execute(MyThread("C"))
//        executorService.execute(MyThread("D"))
//        executorService.execute(MyThread("E"))
    }
    executorService.shutdown()
}


