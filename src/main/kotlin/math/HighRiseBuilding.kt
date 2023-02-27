package math

import java.math.BigDecimal

fun main() {
    val N = readln().toInt()
    val list = readln().split(" ").map { it.toInt() }
    var maxCount = 0
    repeat(N) { currentIndex ->
        var count = 0
        var minLeftGradient = BigDecimal.valueOf(-Double.MAX_VALUE)
        var minRightGradient = BigDecimal.valueOf(-Double.MAX_VALUE)
        val currentX = list[currentIndex]
        for (x in currentIndex + 1 until N) {
            val value = BigDecimal.valueOf((list[x] - currentX) / ((x - currentIndex)).toDouble())
            if (minRightGradient < value) {
                minRightGradient = value
                count++
            }
        }
        for (x in currentIndex - 1 downTo 0) {
            val value = BigDecimal.valueOf(-((currentX - list[x]) / ((currentIndex - x)).toDouble()))
            if (minLeftGradient < value) {
                minLeftGradient = value
                count++
            }
        }
        maxCount = maxCount.coerceAtLeast(count)
    }
    println(maxCount)
}


/*
(y1, x1), (y2, x2)

기울기

|(x2-x1)/(y2-y1)|


 */