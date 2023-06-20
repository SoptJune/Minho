package sort

import kotlin.math.abs

fun main() {
    val N = readln().toInt()
    val array = readln().split(" ").map { it.toInt() }

    if (array.last() <= 0) {
        println(array.last() + array[array.size - 2])
        return
    } else if (array.first() >= 0) {
        println(array.first() + array[1])
        return
    }
    var result = 200_000_000
    var start = 0
    var end = array.size - 1
    while (start < end) {
        val temp = array[start] + array[end]
        if (abs(temp) < abs(result)) {
            result = temp
        }
        if (temp > 0) {
            end--
        } else {
            start++
        }
    }
    println(result)
}