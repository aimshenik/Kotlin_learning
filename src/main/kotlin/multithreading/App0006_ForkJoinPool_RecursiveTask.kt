package com.imshenik

import java.util.concurrent.ForkJoinPool
import java.util.concurrent.RecursiveTask
import kotlin.math.max
import kotlin.random.Random

//ForkJoinPool - распределяет работу среди процессоров компьютера

fun main() {
    println("availableProcessors = " + Runtime.getRuntime().availableProcessors())

    var arr = Array(1000000) { 0 }
    for (i in 0 until arr.size) arr[i] = Random.nextInt()

    println(arr.maxOrNull()) // просто max()

    val t1 = System.currentTimeMillis()
        println(findMax(arr)) //наш метод работающий через forkjoin
    val t2 = System.currentTimeMillis()
    println(t2-t1)

    var maxxxx = 0;
    for (i in 0 until arr.size)
        maxxxx = max(maxxxx,arr[i])
    val t3 = System.currentTimeMillis()
    println(maxxxx)
    println(t3-t2)

}

fun findMax(arr: Array<Int>): Int {
    val forkJoinPool = ForkJoinPool()
    val recursiveTask = FindMaxRecursiveTask(0, arr.size, arr)
    return forkJoinPool.invoke(recursiveTask) //forkJoinPool взял под свой контроль RecursiveTask
}

class FindMaxRecursiveTask(
    val left: Int, val right: Int, val arr: Array<Int>
) : RecursiveTask<Int>() //RecursiveTask разделяет экзекуцию на процессы и передаёт ForkJoin-у
{
    override fun compute(): Int { //метод таски, который возвращает результат
        if (right - left < 1000) { //если участок меньше 1000 то перебором ищем максимальное
            var localMaximum = 0
            for (i in left until right)
                localMaximum = max(localMaximum, arr[i])
            return localMaximum
        } else { //дробим на куски по 1000
            var mid = (left + right) / 2
            val leftTask = FindMaxRecursiveTask(left, mid, arr)
            val rightTask = FindMaxRecursiveTask(mid, right, arr)
            leftTask.fork() //Таска запускается отдельном потоке из того же Пула
            rightTask.fork() //количество может быть любое, не обязательно 2
            return max(leftTask.join(), rightTask.join()) //join() возвращает результат compute()
        }
        return 0
    }
}
