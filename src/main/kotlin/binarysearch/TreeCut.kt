package binarysearch
/*
    백준 나무 자르기 (2805번)
    높이를 mid로 이분탐색 했다.
    높이에 따라서 해당 높이-그 나무 높이만큼 잘린다.
    mid보다 크면 높이 더 올리고, 작으면 높이 더 줄여본다.
 */

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