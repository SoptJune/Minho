package graph

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.LinkedList
import java.util.PriorityQueue
import kotlin.math.min

var realN: Int = 0
var realM: Int = 0
val array = ArrayList<String>()
var search: List<IntArray> = emptyList()
fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val (N, M) = readln().split(" ").map { it.toInt() }
    realN = N - 1
    realM = M - 1
    search = List(N) {
        IntArray(M) {
            Int.MAX_VALUE
        }
    }
    val (jooY, jooX, y2, x2) = readln().split(" ").map { it.toInt() }
    repeat(N) {
        array.add(readln())
    }
    search[jooY - 1][jooX - 1] = 1

    fail2FindSuspect(jooX - 1, jooY - 1)
    bw.write(search[y2 - 1][x2 - 1].toString())
    bw.close()
}

fun fail2FindSuspect(waveX: Int, waveY: Int) {
    val queue = LinkedList<Triple<Int, Int, Int>>()
    val intRangeX = intArrayOf(0, 0, 1, -1)
    val intRangeY = intArrayOf(1, -1, 0, 0)
    queue.add(Triple(waveY, waveX, 1))
    while (queue.isNotEmpty()) {
        val map = queue.poll()
        for (i in 0 until 4) {
            val dx = map.second + intRangeX[i]
            val dy = map.first + intRangeY[i]
            if (dx < 0 || dy < 0 || dx > realM || dy > realN || array[dy][dx] == '*') continue
            if (array[map.first][map.second] == '#') {
                search[map.first][map.second] = min(map.third, search[dy][dx])
            } else if (search[map.first][map.second] < search[dy][dx]) {
                if (array[dy][dx] == '1') {
                    search[dy][dx] = map.third + 1
                    queue.add(Triple(dy, dx, map.third + 1))
                } else {
                    search[dy][dx] = map.third
                    queue.add(Triple(dy, dx, map.third))
                }
            }
        }
    }
}




fun fail1FindSuspect(waveX: Int, waveY: Int) {
    val queue = LinkedList<Pair<Int, Int>>()
    val intRangeX = intArrayOf(0, 0, 1, -1)
    val intRangeY = intArrayOf(1, -1, 0, 0)
    queue.add(Pair(waveY, waveX))
    while (queue.isNotEmpty()) {
        val map = queue.poll()
        for (i in 0 until 4) {
            val dx = map.second + intRangeX[i]
            val dy = map.first + intRangeY[i]
            if (dx < 0 || dy < 0 || dx > realM || dy > realN || array[dy][dx] == '*') continue
            if (array[map.first][map.second] == '#') {
                search[map.first][map.second] = min(search[map.first][map.second], search[dy][dx])
            } else if (search[map.first][map.second] < search[dy][dx]) {
                if (array[dy][dx] == '1') {
                    search[dy][dx] = search[map.first][map.second] + 1
                    queue.add(Pair(dy, dx))
                } else {
                    search[dy][dx] = search[map.first][map.second]
                    queue.add(Pair(dy, dx))
                }
            }
        }
    }
}
