package bruteforce

import java.lang.Integer.max

private var maxOfMax = 0
private var minOfMax = 0

fun main() {
    println(solution(arrayOf(intArrayOf(14, 4), intArrayOf(19, 6), intArrayOf(6, 16), intArrayOf(18, 7), intArrayOf(7, 11))))
}

private fun solution(sizes: Array<IntArray>): Int {
    sizes.map { swapSide(it) }
    return maxOfMax * minOfMax
}

fun swapSide(pair: IntArray) {
    val (first, second) = pair
    return if (first > second) {
        minOfMax = max(second, minOfMax)
        maxOfMax = max(first, maxOfMax)
    } else {
        minOfMax = max(first, minOfMax)
        maxOfMax = max(second, maxOfMax)
    }
}