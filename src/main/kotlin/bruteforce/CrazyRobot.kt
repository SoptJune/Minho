package bruteforce


val intRangeX = intArrayOf(0, 0, 1, -1)
val intRangeY = intArrayOf(1, -1, 0, 0)
val fourWayDirection = DoubleArray(4)
var N = 0
var totalProbability = 0.0

fun main() {
    var visitMap = Array(29) { BooleanArray(29) }
    visitMap[14][14] = true
    readln().split(" ")
        .mapIndexed { index, s -> if (index == 0) N = s.toInt() else fourWayDirection[index - 1] = s.toDouble() * 0.01 }
    DFS(0, 14, 14, visitMap, 1.0)
    println(totalProbability)
}

fun DFS(cnt: Int, currentX: Int, currentY: Int, visited: Array<BooleanArray>, cumulativeResult: Double) {
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