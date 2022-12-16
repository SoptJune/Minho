package datastructure

import java.util.*
/*
    프로그래머스 기능개발
    queue 처리
    일단 냅다 다 넣어두고 맨 앞이 처리되는 순간 나머지도 처리 되나 확인한당,
    그때 처리되는 개수를 기록

 */

val queue = LinkedList<Pair<Int, Int>>()
fun main() {
    solution(intArrayOf(95, 90, 99, 99, 80, 99), intArrayOf(1, 1, 1, 1, 1, 1))
}

fun solution(progresses: IntArray, speeds: IntArray): IntArray {
    progresses.forEachIndexed { index, _ ->
        queue.add(Pair(progresses[index], speeds[index]))
    }
    val list = arrayListOf<Int>()
    var i = 1
    while (queue.isNotEmpty()) {
        val data = queue.peek()
        if (data.first + data.second * i++ >= 100) {
            list.add(find(i))
        }
    }
    return list.toIntArray()
}

fun find(index: Int): Int {
    var count = 0
    while (queue.isNotEmpty()) {
        val data = queue.peek()
        if (data.first + data.second * index < 100) {
            return count
        } else {
            count++
            queue.pop()
        }
    }
    return count
}