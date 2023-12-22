package selfeducation.multithreading

import java.lang.Thread.sleep
import java.util.concurrent.locks.Lock
import java.util.concurrent.locks.ReentrantLock

fun main() {
    val account = Account()

    class MyDepositThread : Thread({ account.deposit(200) })
    class MyWithdrawThread : Thread({ account.withdraw(500) })

    var myDepoThread = MyDepositThread()
    var myWithdrawThread = MyWithdrawThread()

    for (i in 1..10) {
        Thread(myWithdrawThread, "myWithdrawThread-$i").start()
        Thread(myDepoThread, "myDepositThread-$i").start()
    }
}


class Account {
    val lock: Lock = ReentrantLock()
    val condition = lock.newCondition()
    var balance = 0

    fun deposit(amount: Int) {
        lock.lock()
        println("${Thread.currentThread().name} | Deposit $amount$")
        balance += amount
        sleep(10) //чтобы withdraw-поток наверняка уже ждал condition.signalAll()
        condition.signalAll() //проснуться всем ожидающим потокам
        println("${Thread.currentThread().name} | Balance became $balance$")
        lock.unlock()
    }

    fun withdraw(amount: Int) {
        lock.lock()
        println("${Thread.currentThread().name} | Attempt to withdraw $amount$ from balance $balance$")
        while (amount > balance) {
            println("${Thread.currentThread().name} | going to sleep by await()")
            condition.await() //если amount > balance то поток идёт  спать и отпускаем Lock
            println("${Thread.currentThread().name} | waken up by signalAll()")
        }
        balance -= amount
        println("${Thread.currentThread().name} | Withdrawen $amount$ balance became $balance$")
        lock.unlock()
    }
}