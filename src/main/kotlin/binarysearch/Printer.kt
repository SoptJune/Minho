package binarysearch

fun main() {
    println(solution(intArrayOf(2, 1, 3, 2), 2))
    //println(solution(intArrayOf(1, 1, 9, 1, 1, 1), 0))
}

fun solution(priorities: IntArray, location: Int): Int {
    var indexQueue = 0
    var answer = 0
    val queue = priorities.mapIndexed { index, i -> Pair(i, index) }.toMutableList()
    while (true) {
        if (location == queue[indexQueue].second && queue.maxOfOrNull { it.first } == queue[indexQueue].first) {
            answer++
            break
        } else if (queue.maxOfOrNull { it.first } == queue[indexQueue].first) {
            queue.removeAt(indexQueue)
            indexQueue %= queue.size
            answer++
        } else {
            indexQueue = (indexQueue + 1) % (queue.size)
        }
    }
    return answer
}