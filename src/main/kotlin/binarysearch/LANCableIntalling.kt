package binarysearch

fun main() {
    val (K, N) = readln().split(" ").map { it.toInt() }
    var right = 2147483647.0
    var left:Double = 1.0
    var answer = 0
    var cnt = 0.0
    var mid = 0.0
    val array = ArrayList<Int>()
    repeat(K) {
        array.add(readln().toInt())
    }
    while (left <= right) {
        mid = ((left + right) / 2).toInt().toDouble()
        cnt = 0.0
        array.forEach {
            cnt += (it / mid).toInt()
        }
        if (cnt >= N) {
            answer = mid.toInt()
            left = mid + 1
        } else {
            right = mid - 1
        }
    }
    println(answer)
}