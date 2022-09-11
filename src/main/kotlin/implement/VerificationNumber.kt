package implement

import kotlin.math.pow

fun main() {
    val result = (readln().split(" ").map { it.toFloat().pow(2) }.sum()%10).toInt()
    println(result)
}