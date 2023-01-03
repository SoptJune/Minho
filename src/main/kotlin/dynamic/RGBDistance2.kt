package dynamic

import kotlin.math.min

fun main() {
    val N = readln().toInt()
    val rooms = Array(N) { mutableListOf<Int>() }
    var answer = 1000 * N + 1
    repeat(N) { index ->
        rooms[index].addAll(readln().split(" ").map { it.toInt() })
    }
    repeat(3) { repeat ->
        val dp = Array(N) {
            IntArray(3)
        }
        repeat(3) { index ->
            if (repeat == index) dp[0][repeat] = rooms[0][repeat]
            else dp[0][index] = 1000 * N + 1
        }
        for (i in 1 until N) {
            dp[i][0] += min(dp[i - 1][1], dp[i - 1][2]) + rooms[i][0]
            dp[i][1] += min(dp[i - 1][0], dp[i - 1][2]) + rooms[i][1]
            dp[i][2] += min(dp[i - 1][1], dp[i - 1][0]) + rooms[i][2]
        }
        for (i in 0 until 3) {
            if (i == repeat) continue
            answer = min(answer, dp[N - 1][i])
        }
    }
    println(answer)
}