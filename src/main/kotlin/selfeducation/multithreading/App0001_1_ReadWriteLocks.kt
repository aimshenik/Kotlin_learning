package com.imshenik


import java.lang.Thread.currentThread
import java.lang.Thread.sleep
import java.util.concurrent.locks.ReadWriteLock
import java.util.concurrent.locks.ReentrantReadWriteLock

//Read Lock – If no thread acquired the write lock or requested for it, multiple threads can acquire the read lock.
//Write Lock – If no threads are reading or writing, only one thread can acquire the write lock.

fun main() {
    val counter = Counter(0);
    for (i in 1..30)
        Thread(IncrementorThread(counter)).start()
    sleep(100)
    println("-----------")
    for (i in 1..30)
        Thread(CountGetterThread(counter)).start()
    sleep(5000)
    println("-----------")

}

class IncrementorThread(val counter: Counter) : Thread() {
    override fun run() {
        println("--- IncrementorThread ${currentThread().name} STARTED")
        counter.increment()
    }
}

class CountGetterThread(val counter: Counter) : Thread() {
    override fun run() {
        println("--- CountGetterThread ${currentThread().name} STARTED")
        println(counter.getCount())
    }
}

class Counter(var count: Int, val rwLock: ReadWriteLock = ReentrantReadWriteLock()) {
    fun increment() {
        rwLock.writeLock().lock()
        println("${currentThread().name} acquired writelock")
        try {
            count++
            sleep(2000)
        } finally {
            rwLock.writeLock().unlock()
            println("${currentThread().name} released writelock")
        }
    }

    fun getCount(): Int? {
        rwLock.readLock().lock()
        try {
            sleep(3000)
            return count
        } finally {
            rwLock.readLock().unlock()
        }
    }
}

