package bruteforce

import java.util.LinkedList
import kotlin.math.abs
import kotlin.math.min

private lateinit var visitMap: BooleanArray
private lateinit var map: Array<BooleanArray>
fun main() {
    println(
        solution(
            9,
            arrayOf(
                intArrayOf(1, 3),
                intArrayOf(2, 3),
                intArrayOf(3, 4),
                intArrayOf(4, 5),
                intArrayOf(4, 6),
                intArrayOf(4, 7),
                intArrayOf(7, 8),
                intArrayOf(7, 9)
            )
        )
    )

}

private fun solution(n: Int, wires: Array<IntArray>): Int {
    var answer = n
    map = Array(n + 1) {
        BooleanArray(n + 1)
    }
    wires.forEach {
        map[it[0]][it[1]] = true
        map[it[1]][it[0]] = true
    }
    wires.forEachIndexed { index, array ->
        map[array[0]][array[1]] = false
        map[array[1]][array[0]] = false
        answer = min(answer, bfs(array[0], n))
        map[array[0]][array[1]] = true
        map[array[1]][array[0]] = true
    }
    return answer
}

private fun bfs(index: Int, n: Int): Int {
    var count = 1
    visitMap = BooleanArray(n + 1)
    val queue = LinkedList<Int>()
    queue.offer(index)
    while (queue.isNotEmpty()) {
        val value = queue.poll()
        visitMap[value] = true
        for (i in 1 .. n) {
            if (visitMap[i]) continue
            if (map[value][i]) {
                queue.add(i)
                count++
            }
        }
    }
    return abs(count - (n - count))
}

/*
1,3
2, 3
3, 4
4, 5
4, 6
4, 7
7, 8
7, 9
중간을 끊는다.
이때 중간이 시작하는 지점, 끝나는 지점을 저장
시작하는 지점을 목적지로 가지는 친구들로 dfs,
끝나는 지점을 목적지로 가지는 친구들로 dfs



 */