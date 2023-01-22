package dynamic

import kotlin.math.min

fun main() {
    val N = readln().toInt()
    val rooms = Array(N) { mutableListOf<Int>() }
    var answer = 1000 * N + 1  //Int.MAXVALUE 넣어줘도 됨
    repeat(N) { index ->
        rooms[index].addAll(readln().split(" ").map { it.toInt() })
    }
    repeat(3) { repeat ->
        val dp = Array(N) {
            IntArray(3)
        }
        dp[0] = dp[0].mapIndexed { index, i -> if (index == repeat) rooms[0][index] else 1000 * N + 1 }.toIntArray()
        //시작을 고정으로 박아버림
        //나머지는 최대 값 => 1000이하의 수가 N만큼 나오니깐 해당 수
        for (i in 1 until N) {
            dp[i][0] += min(dp[i - 1][1], dp[i - 1][2]) + rooms[i][0]//i번째의 0번방은 i-1번째의 1번방, 2번방중의 최소 값으로 세팅
            dp[i][1] += min(dp[i - 1][0], dp[i - 1][2]) + rooms[i][1]
            dp[i][2] += min(dp[i - 1][1], dp[i - 1][0]) + rooms[i][2]
        }
        answer =
            min(answer, dp[N - 1].filterIndexed { index, i -> index != repeat }.min()) //시작에 넣은 index가 아닌 곳에서만 min을 뽑음
    }
    println(answer)
}