package com.imshenik

import java.util.concurrent.locks.ReentrantLock

fun main() {
    var myThread = MyThread()
    val t1 = Thread(myThread, "T1")
    val t2 = Thread(myThread, "T2")
    t1.start()
    t2.start()
    t1.join()
    t2.join()
    Thread.sleep(3000)
    println(myThread.x)
}

class MyThread(
    private val lock: ReentrantLock = ReentrantLock(),
    var x: Int = 0
) : Thread() {
    override fun run() {
        lock.lock()
        for (j in 1..5) {
            x += 1
            println("THREAD ${currentThread()} made me up to $x")
        }
        lock.unlock()
    }
}
