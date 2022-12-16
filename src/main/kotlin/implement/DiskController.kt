package implement

import java.util.PriorityQueue
import kotlin.math.floor


fun main() {
    println(solution(arrayOf(intArrayOf(0, 3), intArrayOf(1, 9), intArrayOf(2, 6))))
}

private fun solution(jobs: Array<IntArray>): Int {
    var end = 0
    var count = 0
    var index = 0
    var answer = 0
    val data = jobs.map { it[0] to it[1] }.sortedBy { it.first }
    val pq = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    while (count < jobs.size) {
        while (index < data.size && data[index].first <= end) {
            pq.add(data[index++])
        }
        if (pq.isEmpty()) {
            end = data[index].first
        } else {
            val value = pq.poll()
            answer += value.second + end - value.first
            end += value.second
            count++
        }
    }
    return floor((answer / data.size).toDouble()).toInt()
}