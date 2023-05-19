package com.imshenik

import java.lang.Thread.currentThread
import java.lang.Thread.sleep
import java.util.concurrent.locks.ReadWriteLock
import java.util.concurrent.locks.ReentrantReadWriteLock

fun main() {
    val counter = Counter(0);
    for (i in 1..3)
        Thread(IncrementorThread(counter)).start()
    sleep(100)
    println("-----------")
    for (i in 1..3)
        Thread(CountGetterThread(counter)).start()
    sleep(5000)
    println("-----------")
    for (i in 1..3)
        Thread(IncrementorThread(counter)).start()
    sleep(20000)
    println("-----------")
    Thread(CountGetterThread(counter)).start()

}

class IncrementorThread(val counter: Counter) : Thread() {
    override fun run() {
        println("--- IncrementorThread ${Thread.currentThread().name} STARTED")
        counter.increment()
    }
}

class CountGetterThread(val counter: Counter) : Thread() {
    override fun run() {
        println("--- CountGetterThread ${Thread.currentThread().name} STARTED")
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

