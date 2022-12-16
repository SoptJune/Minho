package graph

import java.util.LinkedList
import java.util.Queue
import kotlin.math.max
import kotlin.math.min
/*
    백준 2206번 (벽 부수고 이동하기)
    BFS 풀이 2차원 배열
    벽을 하나 부시고 탐색, 끝까지 벽을 하나 부시고 탐색
 */

private lateinit var answer: Array<Array<IntArray>>
private lateinit var tour: Array<Array<BooleanArray>>
private var endN = 0
private var endM = 0
fun main() {
    val (N, M) = readln().split(' ').map { it.toInt() }
    endN = N
    endM = M
    val queue: Queue<Triple<Int, Int, Boolean>> = LinkedList<Triple<Int, Int, Boolean>>()
    val intRangeX = intArrayOf(0, 0, 1, -1)
    val intRangeY = intArrayOf(1, -1, 0, 0)
    var miro = ArrayList<MutableList<Char>>()
    tour = Array(N) { Array(M) { BooleanArray(2) } }
    repeat(N) {
        miro.addAll(listOf(readln().toMutableList()))
    }

    answer = Array(N) { Array(M) { IntArray(2) } }
    answer[N - 1][M - 1][0] = -1
    answer[N - 1][M - 1][1] = -1
    answer[0][0][0] = 1
    queue.offer(Triple(0, 0, false))
    while (queue.isNotEmpty()) {
        val data = queue.poll()
        val visit = data.third

        if (visit) {
            for (i in 0 until 4) {
                val dx = data.second + intRangeX[i]
                val dy = data.first + intRangeY[i]
                if (dx < 0 || dy < 0 || dx >= M || dy >= N) continue
                if (dx == M - 1 && dy == N - 1) {
                    insertMinValue(1, data)
                    continue
                }
                if (!tour[dy][dx][1] && miro[dy][dx] == '0') {
                    queue.add(Triple(dy, dx, true))
                    answer[dy][dx][1] = answer[data.first][data.second][1] + 1
                    tour[dy][dx][1] = true
                }
                //tour[dy][dx] = true
            }
        } else {
            for (i in 0 until 4) {
                val dx = data.second + intRangeX[i]
                val dy = data.first + intRangeY[i]
                if (dx < 0 || dy < 0 || dx >= M || dy >= N) continue
                if (dx == M - 1 && dy == N - 1) {
                    insertMinValue(0, data)
                    continue
                }
                if (!tour[dy][dx][0]) {
                    if (miro[dy][dx] == '0') {
                        queue.add(Triple(dy, dx, false))
                        answer[dy][dx][0] = answer[data.first][data.second][0] + 1
                        tour[dy][dx][0] = true
                    } else {
                        queue.add(Triple(dy, dx, true))
                        answer[dy][dx][1] = answer[data.first][data.second][0] + 1
                        tour[dy][dx][1] = true
                    }
                }
            }
        }
    }
    if (answer[N - 1][M - 1][0] == -1 || answer[N - 1][M - 1][1] == -1) {
        print(max(answer[N - 1][M - 1][0], answer[N - 1][M - 1][1]))
    } else {
        print(min(answer[N - 1][M - 1][0], answer[N - 1][M - 1][1]))
    }
}

fun insertMinValue(isWallBroken: Int, data: Triple<Int, Int, Boolean>) {
    answer[endN - 1][endM - 1][isWallBroken] =
        if (answer[endN - 1][endM - 1][isWallBroken] == -1) answer[data.first][data.second][isWallBroken] + 1
        else min(answer[data.first][data.second][isWallBroken] + 1, answer[endN - 1][endM - 1][isWallBroken])
    tour[endN - 1][endM - 1][isWallBroken] = true
}
//DFS
/*for (i in 0 until N) {
    for (j in 0 until M) {
        if (miro[i][j] == '1') {
            miro[i][j] = '0'
            tour[i][j]=true
            searchBFSGraph(1, 0, 0)
            miro[i][j] = '1'
            tour = Array(N) { BooleanArray(M) }
        }
    }
}
print(maxCount)
}*/
/*

fun searchBFSGraph(): Int {
    while (queue.isNotEmpty()) {
        val data = queue.poll()
        for (i in 0 until 4) {
            val dx = data.second + intRangeX[i]
            val dy = data.first + intRangeY[i]

            if (dx < 0 || dy < 0 || dx >= endM || dy >= endN) continue
            if (!tour[dy][dx] && miro[dy][dx] != '0') {
                tour[dy][dx] = true
                if(dx==endM-1 && dy == endN){

                if (minCount == -1) {
                    answer[dy][dx] = answer[data.first][data.second] + 1
                    minCount = answer[dy][dx]
                }else{

                }

                }
                answer[dy][dx] = answer[data.first][data.second] + 1
                queue.add(Pair(dy, dx))
            }
        }
    }
    return answer[endN - 1][endM - 1]
}*/

/*
fun searchDFSGraph(count: Int, currentX: Int, currentY: Int) {
    if (currentX == endM - 1 && currentY == endN - 1) {
        minCount = if (minCount == -1) count
        else min(count, minCount)
    }

    for (i in 0 until 4) {
        val dx = currentX + intRangeX[i]
        val dy = currentY + intRangeY[i]

        if (dx < 0 || dy < 0 || dx >= endM || dy >= endN) continue
        if (!tour[dy][dx] && miro[dy][dx] != '1') {
            tour[dy][dx] = true
            searchDFSGraph(count + 1, dx, dy)
            tour[dy][dx] = false
        }
    }
}*/
