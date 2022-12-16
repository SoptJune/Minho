package graph

import java.util.PriorityQueue

/*
    프로그래머스 디펜스 게임
    PQ 풀이

    무적권 쓰는거 최소로 하게 합시다.
    계속 넣다가, pq size가 무적권보다 커질 때
    pq에서 제일 enemy 적은걸 뺀다.
    n이 0보다 작아질 때까지 반복
    pq에 남아있는건 제일 큰 친구들일테니 무적권으로 막으면 된다.
 */

fun main() {
    println(solution(7, 3, intArrayOf(4, 2, 4, 5, 3, 3, 1)))
}

fun solution(n: Int, k: Int, enemy: IntArray): Int {
    if (enemy.size == k) {
        return k
    }
    val pq = PriorityQueue<Int>()
    var currentN = n
    enemy.forEachIndexed { index, i ->
        pq.offer(i)
        if (pq.size > k) {
            currentN -= pq.poll()
        }
        if (currentN < 0)
            return index
    }
    return enemy.size
}

/*
private fun isDefensed(mid: Int, n: Int, k: Int, enemy: IntArray): Boolean {
    val pq = PriorityQueue<Int>()
    var currentN = n
    for (i in 0 .. mid) {
        pq.add(enemy[i])
    }
    while (!pq.isEmpty()) {
        val value = pq.poll()
        if (currentN >= value) {
            currentN -= value
            continue
        }
        pq.add(value)
        return (k >= pq.size)
    }
    return true
}
*/
/*
private fun findMap(currentN: Int, currentRound: Int, remainInvincibility: Int, map: IntArray) {
    if (currentRound == map.size) {
        maxRound = map.size
    } else if (currentN - map[currentRound] < 0 && remainInvincibility == 0) {
        maxRound = maxRound.coerceAtLeast(currentRound)
    } else {
        if (currentN - map[currentRound] < 0 && remainInvincibility != 0) {
            findMap(currentN, currentRound + 1, remainInvincibility - 1, map)
        } else {
            if (remainInvincibility != 0) {
                findMap(currentN, currentRound + 1, remainInvincibility - 1, map)
            }
            findMap(currentN - map[currentRound], currentRound + 1, remainInvincibility, map)
        }
    }
}
 */