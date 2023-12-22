package com.imshenik

import java.util.concurrent.ConcurrentHashMap
import java.util.concurrent.locks.ReentrantReadWriteLock

object EEEEE {
    private val viewLock = ConcurrentHashMap<String, ReentrantReadWriteLock>()

    fun getViewLock(view: String): ReentrantReadWriteLock = viewLock.getOrPut(view) { ReentrantReadWriteLock() }
}

fun main() {
    var lock1 = EEEEE.getViewLock("AAA")
    var lock2 = EEEEE.getViewLock("BBB")
    var lock3 = EEEEE.getViewLock("AAA")
    println()


}
