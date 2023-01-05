package graph

import java.util.PriorityQueue

fun main() {
    println(solution(intArrayOf(-16, 27, 65, -2, 58, -92, -71, -68, -61, -33)))
    println(solution(intArrayOf(9, -1, -5)))
}

private fun solution(a: IntArray): Int {
    var count = 0
    val rightArray = IntArray(a.size)
    val leftArray = IntArray(a.size)
    var minRight = Int.MAX_VALUE
    var minLeft = Int.MAX_VALUE
    if (a.size <= 3) {
        return a.size
    }
    for (i in a.indices) {
        minRight = minRight.coerceAtMost(a[(a.size - 1) - i])
        rightArray[(a.size - 1) - i] = minRight
        minLeft = minLeft.coerceAtMost(a[i])
        leftArray[i] = minLeft
    }
    println("left  ${leftArray.toList()}")
    println("right ${rightArray.toList()}")
    for (i in a.indices) {
        if (!(leftArray[i] < a[i] && rightArray[i] < a[i])) {
            count++
        }
    }
    return count
}

private fun solution1(a: IntArray): Int {
    if (a.size == 1) {
        return 1
    }
    val rightQueue = PriorityQueue<Int>()
    rightQueue.addAll(a.toList())
    var minRight = rightQueue.poll()
    val leftQueue = PriorityQueue<Int>()
    var minLeft = a.first()
    rightQueue.remove(a.first())
    leftQueue.add(a.first())
    var count = 2
    for (i in 1 until a.size - 1) {
        if (minRight == a[i]) {
            count++
            minLeft = minRight.coerceAtMost(minLeft)
            minRight = rightQueue.poll()
            continue
        }
        if (minLeft > a[i] || minRight > a[i]) {
            count++
        }
        if (minLeft > a[i]) {
            minLeft = a[i]
        }
        rightQueue.remove(a[i])
    }
    return count
}

private fun solution2(a: IntArray): Int {
    var count = 2

    var minLeft = a.first()
    var minRight = a.min()
    if (a.size == 1) {
        return 1
    }
    for (i in 1 until a.size - 1) {
        if (minLeft > a[i - 1]) {
            minLeft = a[i - 1]
        }
        if (a[i] == minRight) {
            if (minLeft > minRight) {
                minLeft = minRight
            }
            minRight = a.slice(i + 1 until a.size).minOrNull()!!
            count++
            continue
        }
        if (minLeft < a[i] && minRight < a[i]) {
            println("continue ${a[i]} minleft $minLeft minRight $minRight")
            continue
        }
        count++
    }
    return count
}