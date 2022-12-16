package greedy
/*
    프로그래머스 섬 연결하기
    그리디 풀이, 스쿠스칼, 유니온 파인드, 스패닝 트리
    n개의 섬 사이에 다리를 건설하는 비용(costs)이 주어질 때,
    최소의 비용으로 모든 섬이 서로 통행 가능하도록 만든다
    경로가 짧은 순으로 정렬, 이미 연결 된거면(parent가 같다면) 연결 안함
 */

fun main() {
    println(
        solution(
            4,
            arrayOf(
                intArrayOf(0, 1, 1),
                intArrayOf(0, 2, 2),
                intArrayOf(1, 2, 5),
                intArrayOf(1, 3, 1),
                intArrayOf(2, 3, 8)
            )
        )
    )
}

private lateinit var unionFind: IntArray
fun solution(n: Int, costs: Array<IntArray>): Int {
    val array = costs.map { Triple(it[0], it[1], it[2]) }.sortedBy { it.third }
    unionFind = IntArray(n) { it }
    var answer = array.first().third
    unionFind[array.first().second] = array.first().first
    var count = 0
    array.forEach { island ->
        if (count == n - 1) {
            return@forEach
        } else if (!isParentSame(island.first, island.second)) {
            count++
            answer += island.third
            unionCombine(island.first, island.second)
        }
    }
    return answer
}

fun findParent(island: Int): Int {
    if (unionFind[island] == island) {
        return island
    } else {
        return findParent(unionFind[island])
    }
}

fun unionCombine(first: Int, second: Int) {
    val node1 = findParent(first)
    val node2 = findParent(second)
    if (node1 < node2) {
        unionFind[node2] = node1
    } else {
        unionFind[node1] = node2
    }
}

fun isParentSame(first: Int, second: Int) = findParent(first) == findParent(second)


/*

0, 1, 1
1, 3, 1
0, 2, 2
1, 2, 5
2, 3, 8

0, 1, 2, 3
0  0  2  3
0  0  2  0

   0  1  2  3
0  0  1  2  0
1  1  0  5  1
2  2  5  0  8
3  0  1  8  0

*/
