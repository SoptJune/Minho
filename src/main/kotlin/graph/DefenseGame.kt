package graph

import java.util.PriorityQueue


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