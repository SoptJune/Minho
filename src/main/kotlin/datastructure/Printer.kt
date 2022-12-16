package datastructure

/*
    프로그래머스 프린터
    이건 큐인데?
    원형 큐로 해결
    현재 리스트에서 제일 큰 놈이 본인인 경우에만 remove
    Target 출력하고 끝

    priorities	location	return
    [2, 1, 3, 2]	2	     1
 */

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