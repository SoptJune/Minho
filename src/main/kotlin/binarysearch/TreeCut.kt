package binarysearch

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val array = ArrayList<Int>()
    var right = 2_000_000_000.0
    var left = 0.0
    var answer = 0
    var mid = 0.0
    var sum = 0.0
    array.addAll(readln().split(" ").map { it.toInt() })
    while (left <= right) {
        mid = ((left + right) / 2).toInt().toDouble()
        sum = 0.0
        array.forEach {
            sum += if (mid < it) it - mid else 0.0
        }
        if (sum >= M) {
            answer = mid.toInt()
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    println(answer)
}