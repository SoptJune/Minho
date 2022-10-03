package graph

import java.util.LinkedList
import java.util.Queue
import java.util.Stack
import kotlin.math.min


fun main() {

    var answer: Array<IntArray>
    val queue: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
    var minCount = -1
    val intRangeX = intArrayOf(0, 0, 1, -1)
    val intRangeY = intArrayOf(1, -1, 0, 0)
    val (N, M) = readln().split(' ').map { it.toInt() }
    val tour = Array(N) { BooleanArray(M) }
    var miro = ArrayList<MutableList<Pair<Char, Boolean>>>()
    repeat(N) {
        miro.addAll(listOf(readln().map {
            Pair(it, false)
        }.toMutableList()))
    }
    answer = Array(N) { IntArray(M) }

    answer[N - 1][M - 1] = -1
    answer[0][0] = 1

    queue.offer(Pair(0, 0))
    while (queue.isNotEmpty()) {
        val data = queue.poll()
        for (i in 0 until 4) {
            val dx = data.second + intRangeX[i]
            val dy = data.first + intRangeY[i]

            if (dx < 0 || dy < 0 || dx >= M || dy >= N) continue
            if (dx == M && dy == N) {
                answer[dy][dx] =
                    if (answer[dy][dx] == -1) answer[data.first][data.second] + 1
                    else min(answer[data.first][data.second] + 1, answer[dy][dx])
            }
            if (!tour[dy][dx]) {
                if (miro[data.first][data.second].second) {
                    if (miro[dy][dx].first == '0') {
                        tour[dy][dx] = true
                        miro[dy][dx] = Pair(miro[dy][dx].first, true)
                        answer[dy][dx] = answer[data.first][data.second] + 1
                        queue.add(Pair(dy, dx))
                    } else continue
                } else if (miro[dy][dx].first == '1' && !miro[dy][dx].second) {
                    tour[dy][dx] = true
                    miro[dy][dx] = Pair(miro[dy][dx].first, true)
                    answer[dy][dx] = answer[data.first][data.second] + 1
                    queue.add(Pair(dy, dx))
                } else if (miro[dy][dx].first == '0') {
                    tour[dy][dx] = true
                    answer[dy][dx] = answer[data.first][data.second] + 1
                    queue.add(Pair(dy, dx))
                }
            }
        }
    }

    print(answer[N - 1][M - 1])
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


    while (stack.isNotEmpty()) {
        val data = stack.pop()
        for (i in 0 until 4) {
            val dx = data.second + intRangeX[i]
            val dy = data.first + intRangeY[i]

            if (dx < 0 || dy < 0 || dx >= endM || dy >= endN) continue
            if (!tour[dy][dx] && miro[dy][dx] != '1') {
                tour[dy][dx] = true
                answer[dy][dx] = answer[data.first][data.second] + 1
                stack.push(Pair(dy, dx))
            }
        }
    }
    answer.forEach {
        println(it.toList())
    }
    return answer[endN - 1][endM - 1]
}
*/

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
