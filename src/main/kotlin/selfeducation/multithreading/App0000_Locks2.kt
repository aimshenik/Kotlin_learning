package com.imshenik

import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

fun main() {
    var myThread = MyThread2()
    val t1 = Thread(myThread, "T1")
    val t2 = Thread(myThread, "T2")
    t1.start()
    t2.start()
    Thread.sleep(3000)
    println(myThread.x)
}

class MyThread2 : Thread() {
    val lock = ReentrantLock()
    var x: Int = 0
    override fun run() {
        lock.withLock {
            for (j in 1..10000) {
                x = x + 1
                println("THREAD ${Thread.currentThread()} made me up to $x")
            }
        }
    }
}
