package com.imshenik.selfeducation.leetcode.javasolutions

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    var arr1 = intArrayOf(1, 2)
    var arr2 = intArrayOf(3, 4)
    println(findMedianSortedArrays(arr1, arr2) == 2.5)
    arr1 = intArrayOf(1, 2, 100)
    arr2 = intArrayOf(3, 4)
    println(findMedianSortedArrays(arr1, arr2) == 3.0)
    arr1 = intArrayOf()
    arr2 = intArrayOf(3)
    println(findMedianSortedArrays(arr1, arr2) == 3.0)
    arr1 = intArrayOf(1)
    arr2 = intArrayOf(3)
    println(findMedianSortedArrays(arr1, arr2) == 2.0)
    arr1 = intArrayOf(0)
    arr2 = intArrayOf(0)
    println(findMedianSortedArrays(arr1, arr2) == 0.0)


//    val arr3 = intArrayOf(1,2,9)
//    val arr4 = intArrayOf(3,4,8,7)
//    println(median(arr3))
//    println(median(arr4))
}

fun findMedianSortedArrays(nums1: IntArray, nums2: IntArray): Double {
    if (nums1.isEmpty()) return median(nums2)
    if (nums2.isEmpty()) return median(nums1)
    val accumulator = ArrayList<Int>()
    var iFinished = false
    var jFinished = false
    var iIndex = 0
    var jIndex = 0
    while (true) {
        if (iFinished && jFinished) {
            break
        } else if (!iFinished && jFinished) {
            accumulator.addAll(nums1.toList().subList(iIndex, nums1.size))
            break
        } else if (iFinished && !jFinished) {
            accumulator.addAll(nums2.toList().subList(jIndex, nums2.size))
            break
        } else if (nums1[iIndex] <= nums2[jIndex]) {
            accumulator.add(nums1[iIndex])
            iFinished = iIndex + 1 == nums1.size
            iIndex++
        } else {
            accumulator.add(nums2[jIndex])
            jFinished = jIndex + 1 == nums2.size
            jIndex++
        }
    }
    return median(accumulator.toIntArray())
}

fun median(arr: IntArray): Double {
    if (arr.size == 1) return arr[0].div(1.0)
    if (arr.size == 2) return (arr[0] + arr[1]).div(2.0)
    val isOdd = arr.size % 2 == 0
    val halfIndex = if (!isOdd) arr.size / 2 else arr.size / 2 - 1
    return if (isOdd) (arr[halfIndex] + arr[halfIndex + 1]).div(2.0) else arr[halfIndex].div(1.0)
}