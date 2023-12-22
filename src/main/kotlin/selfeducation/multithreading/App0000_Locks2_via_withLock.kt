package com.imshenik

import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

fun main() {
    var myThread = MyThread3()
    val t1 = Thread(myThread, "T1")
    val t2 = Thread(myThread, "T2")
    listOf(t1, t2).forEach {
        with(it) {
            start()
//            join()
        }
    }
    Thread.sleep(3000)
    println(myThread.x)
}

class MyThread3(
    private val lock: ReentrantLock = ReentrantLock(),
    var x: Int = 0
) : Thread() {

    override fun run() {
        for (j in 1..10000) {
            lock.withLock {
                x += 1
//                sleep(500)
                println("THREAD ${Thread.currentThread()} made me up to $x")
            }
        }
    }
}
