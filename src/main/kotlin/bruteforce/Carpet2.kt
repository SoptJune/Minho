package bruteforce

import kotlin.math.sqrt

fun main() {
    println(solution(24, 24).toList())
}

private fun solution(brown: Int, yellow: Int): IntArray {
    val sum = brown + yellow
    for (i in 3..sqrt(sum.toDouble()).toInt()) {
        if (sum % i == 0) {
            if (brown == (sum - ((i - 2) * (sum / i - 2)))) {
                return intArrayOf((sum / i), i)
            }
        }
    }
    return intArrayOf()
}