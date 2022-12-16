package bruteforce

/*
    백준 미친 로봇 (1405번)
    DFS 풀이, 2차원 배열
    단순한 경로로 이동할 확률을 구하라고 한다 ㅋㅋㅋ
    이거 내 기억엔 빡셌으나 지금 보니 쉽네
    방문한 곳 True 해놓고 끝까지 N번 이동 시켰을 때
    방문하지 않은 곳으로만 여행한 친구들의 확률을 더한다.
 */

private val fourWayDirection = DoubleArray(4)
private var N = 0
private var totalProbability = 0.0

fun main() {
    var visitMap = Array(29) { BooleanArray(29) }
    visitMap[14][14] = true
    readln().split(" ")
        .mapIndexed { index, s -> if (index == 0) N = s.toInt() else fourWayDirection[index - 1] = s.toDouble() * 0.01 }
    DFS(0, 14, 14, visitMap, 1.0)
    println(totalProbability)
}

private fun DFS(cnt: Int, currentX: Int, currentY: Int, visited: Array<BooleanArray>, cumulativeResult: Double) {

    val intRangeX = intArrayOf(0, 0, 1, -1)
    val intRangeY = intArrayOf(1, -1, 0, 0)
    if (cnt == N) {
        totalProbability += cumulativeResult
        return
    }
    for (i in 0 until 4) {
        if (fourWayDirection[i] == 0.0) continue
        val dx = currentX + intRangeX[i]
        val dy = currentY + intRangeY[i]
        if (dx < 0 || dy < 0 || dx > 28 || dy > 28) continue
        if (!visited[dx][dy]) {
            visited[dx][dy] = true
            DFS(cnt + 1, dx, dy, visited, cumulativeResult * fourWayDirection[i])
            visited[dx][dy] = false
        }
    }
}