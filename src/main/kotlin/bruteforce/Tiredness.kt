package bruteforce

import java.util.PriorityQueue

private var max :Int = 0
private lateinit var visitMap:BooleanArray
private lateinit var map:List<Pair<Int,Int>>
fun main() {
    println(
        solution(
            80,
            arrayOf(intArrayOf(80, 20), intArrayOf(50, 40), intArrayOf(30, 10))
        )
    )
}

private fun solution(k: Int, dungeons: Array<IntArray>): Int {

    visitMap = BooleanArray(dungeons.size)
    map = dungeons.map { dungeon ->
        dungeon[0] to dungeon[1]
    }
    map.forEachIndexed { index, pair ->
        if (pair.first <= k) {
            findTiredNess(k, index, 1)
        }
    }
    return max
}

fun findTiredNess(k: Int, index: Int, count: Int) {
    visitMap[index] = true
    var tired = k
    tired -= map[index].second
    map.forEachIndexed { index, pair ->
        if (!visitMap[index] && pair.first <= tired) {
            findTiredNess(tired, index, count + 1)
        }
    }
    max = max.coerceAtLeast(count)
    visitMap[index] = false
}

fun solution2(k: Int, dungeons: Array<IntArray>): Int {
    val map = dungeons.map { dungeon ->
        dungeon[0] to dungeon[1]
    }.filter { it.first <= k }
    var count = 0
    val pq = PriorityQueue<Pair<Int, Int>>(Comparator { o1, o2 -> o1.second - o2.second })
    var maxTried = 0
    var sumTried = 0
    var currentK = k
    map.forEach {
        if (it.first <= currentK) {
            pq.offer(it)
            maxTried = maxTried.coerceAtLeast(it.first)
            sumTried += it.second
            if (sumTried >= currentK) {
                val value = pq.poll()
                count++
                currentK -= value.second
                sumTried -= value.second
                maxTried = if (maxTried < value.first) pq.maxOf { it.first } else maxTried
                pq.removeIf { it.first > currentK }
            }
        }
    }
    count += pq.size
    return count
}