package com.imshenik

import java.util.concurrent.Semaphore

//SEMAPHORE - класс, контролирует сколько потоков работают над одним объектом
fun main() {
    val semaphore = Semaphore(2) // 2 threads in semaphore

    class CheckSemaphore(val semaphore: Semaphore) : Thread() {
        override fun run() {
            semaphore.acquire()
            for (i in 1..5) println("${currentThread().name} + $i")
            sleep(2000)
            println("${currentThread().name}+++++++++++++++++++++++++++++++++++++++++++")
            semaphore.release()
        }
    }
    //стартует много потоков, но только 2 работают единомоментно
    Thread(CheckSemaphore(semaphore), "A").start()
    Thread(CheckSemaphore(semaphore), "AA").start()
    Thread(CheckSemaphore(semaphore), "B").start()
    Thread(CheckSemaphore(semaphore), "BB").start()
    Thread(CheckSemaphore(semaphore), "C").start()
    Thread(CheckSemaphore(semaphore), "CC").start()
    Thread(CheckSemaphore(semaphore), "D").start()
    Thread(CheckSemaphore(semaphore), "DD").start()
    Thread(CheckSemaphore(semaphore), "E").start()
    Thread(CheckSemaphore(semaphore), "EE").start()

}

