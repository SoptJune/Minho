package datastructure

import java.util.*

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