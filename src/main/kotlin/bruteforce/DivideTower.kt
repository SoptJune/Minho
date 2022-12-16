package bruteforce

import java.util.LinkedList
import kotlin.math.abs
import kotlin.math.min

/*
    프로그래머스 전력망 둘로 나누기
    BFS 풀이 이차원 배열로 그래프 풀이
    n	    wires	                                        result
    9	[[1,3],[2,3],[3,4],[4,5],[4,6],[4,7],[7,8],[7,9]]	3
    result는 잘린 2개의 트리의 노드의 갯수의 최소 값
    연결 하나씩 끊어보고 BFS 돌려본다.
    시작 점을 true로 박아버리는게 중요, 그래야 떨거지 노드들도 검사하니깐
 */

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