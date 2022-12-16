package binarysearch

import kotlin.math.max

/*
    프로그래머스 징검다리
    distance	rocks	n	return
    25	[2, 14, 11, 21, 17]	2	4
    바위 2개를 제거 했을 때 각 바위 거리들의 최소 값

    n개를 빼기가 너무 애매했음,
    그래서 얘도 최소 값을 binary 로 찾는 짓을 했음
    최소 값을 정해놓고, element - previous가 mid보다 커지는 순간에만 rock을 제거 했음
    rock count가 n보다 작아지는 순간에만 minMax에 최대 값을 넣어주었당.
 */

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
    return minMax
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
