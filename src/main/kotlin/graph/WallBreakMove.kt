package graph

import kotlin.math.min

var endN = 0
var endM = 0
lateinit var tour: Array<BooleanArray>
lateinit var miro: ArrayList<MutableList<Char>>
lateinit var answer: Array<IntArray>

val intRangeX = intArrayOf(0, 0, 1, -1)
val intRangeY = intArrayOf(1, -1, 0, 0)

var maxCount = -1
fun main() {
    val (N, M) = readln().split(' ').map { it.toInt() }
    endN = N
    endM = M
    tour = Array(N) { BooleanArray(M) }
    miro = ArrayList<MutableList<Char>>()
    answer = Array(N) { IntArray(M) }
    answer[N - 1][M - 1] = -1
    answer[0][0] = 1
    answer.forEach {
        println(it.toList())
    }
    repeat(N) {
        miro.addAll(listOf(readln().toMutableList()))
    }
    for (i in 0 until N) {
        for (j in 0 until M) {
            if (miro[i][j] == '1') {
                miro[i][j] = '0'
                searchDFSGraph(1, 0, 0)
                miro[i][j] = '1'
                tour = Array(N) { BooleanArray(M) }
            }
        }
    }
    print(maxCount)
}

fun searchDFSGraph(count: Int, currentX: Int, currentY: Int) {
    if (currentX == endM - 1 && currentY == endN - 1) {
        maxCount = if (maxCount == -1) count
        else min(count, maxCount)
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
}