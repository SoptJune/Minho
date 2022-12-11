package dynamic

import kotlin.math.max

/*
    백준 계단 오르기 (실버 3)
 */

fun main() {
    val stair = mutableListOf<Int>()
    val N = readln().toInt()
    repeat(N) {
        stair.add(readln().toInt())
    }
    if (N <= 2) {
        println(stair.sum())
        return
    }
    val weight = IntArray(N) { 0 }
    weight[0] = stair[0]
    weight[1] = stair[0] + stair[1]
    weight[2] = max(stair[0] + stair[2], stair[1] + stair[2])
    for (i in 3 until N) {
        weight[i] = max(weight[i - 2] + stair[i], stair[i - 1] + stair[i] + weight[i - 3])
    }
    println(weight[N-1])
}
/*
첫번째 밟은 경우
첫번째 두번째 밟은 경우
Max(첫번째 세번째 밟은 경우, 두번째 세번째 밟은 경우)

 */