package greedy

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
    /*println(
        solution(
            7,
            arrayOf(
                intArrayOf(2, 3, 7),
                intArrayOf(3, 6, 13),
                intArrayOf(3, 5, 23),
                intArrayOf(5, 6, 25),
                intArrayOf(0, 1, 29),
                intArrayOf(1, 5, 34),
                intArrayOf(1, 2, 35),
                intArrayOf(4, 5, 53),
                intArrayOf(0, 4, 75)
            )
        )
    )*/
    /*println(
        solution(
            5,
            arrayOf(
                intArrayOf(0, 1, 5),
                intArrayOf(1, 2, 3),
                intArrayOf(2, 3, 3),
                intArrayOf(3, 1, 2),
                intArrayOf(3, 0, 4),
                intArrayOf(2, 4, 6),
                intArrayOf(4, 0, 7),
            )
        )
    )*/
    /*println(
        solution(
            5,
            arrayOf(
                intArrayOf(0, 1, 1),
                intArrayOf(3, 4, 1),
                intArrayOf(1, 2, 2),
                intArrayOf(2, 3, 4),
            )
        )
    )*/
}

lateinit var unionFind: IntArray
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
