package binarysearch

import kotlin.math.max

fun main() {
    println(solution(25, intArrayOf(2, 14, 11, 21, 17), 2))
}

fun solution(distance: Int, rocks: IntArray, n: Int): Int {
    val sortRocks = (rocks + distance).sorted().toMutableList()
    var minMax = 0
    var (left, right, mid) = Triple(1, distance, (1 + distance) / 2)
    while (left <= right) {
        var previous = 0
        var count = 0
        mid = (left + right) / 2
        sortRocks.forEach { element ->
            if (mid > element - previous) {
                count++
            } else previous = element
        }
        if (count <= n) {
            left = mid + 1
            minMax = max(minMax, mid)
        } else {
            right = mid - 1
        }
    }
    /*
    val eachDistancePair = eachDistancePairReturn(sortRocks)
    val minMax = eachDistancePair[n - 1]
    eachDistancePair.take(n).forEach { sortRocks.removeAt(it.second) }
    */
    //eachDistanceMinValue(sortRocks)
    return minMax
}

fun eachDistancePairReturn(rocks: List<Int>): List<Pair<Int, Int>> {
    var previous = 0
    var temp = 0
    return rocks.mapIndexed { index, element ->
        temp = element - previous
        previous = element
        Pair(temp, index)
    }.sortedBy { it.first }
}

fun eachDistanceMinValue(rocks: List<Int>): Int {
    var previous = 0
    var minValue = 1_000_000_000
    rocks.forEach { element ->
        minValue = minValue.coerceAtMost(element - previous)
        previous = element
    }
    return minValue
}

/*

11, 3, 7

0, 2, 11, 14, 17, 21, 25
  2, 9,  3,  3,  4,  4

5 -> 6

11, 14, 21
11, 3, 7, 4

11, 17, 21
11, 6, 4, 4

distance 28, n = 3
rocks = [2, 11, 13, 16, 20, 23]
eachDistance = [2, 9, 2, 3, 4, 3, 5]
2 2개 (2, 13)
*/
