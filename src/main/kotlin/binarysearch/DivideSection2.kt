package binarysearch

private lateinit var array: List<Int>
fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    array = readln().split(" ").map { it.toInt() }
    var mid = 0
    var res = Int.MAX_VALUE
    if (N == M) {
        println(0)
    } else if (M == 1) {
        println(array.max() - array.min())
    } else {
        var left = 0
        var right = array.max()
        while (left <= right) {
            mid = (left + right) / 2
            if (compareMidValue(mid, M)) {
                if (res > mid) res = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        println(res)
    }
}

private fun compareMidValue(mid: Int, M: Int): Boolean {
    var (minValue, maxValue, count) = Triple(array.first(), array.first(), 1)
    array.forEach { num ->
        if (minValue > num) {
            minValue = num
        }
        if (maxValue < num) {
            maxValue = num
        }
        if ((maxValue - minValue) > mid) {
            count++
            minValue = num
            maxValue = num
        }
    }
    return count <= M
}