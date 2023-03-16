package bruteforce

import java.util.PriorityQueue

/*
    프로그래머스 피로도
    k	dungeons	                result
    80	[[80,20],[50,40],[30,10]]	3
    던전 탐험 최대 갯수 출력
    dungeons 돌리면서 피로도 되는건 dfs 돌려본다.
    max 처리 해서 저장하면 끝
 */

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
