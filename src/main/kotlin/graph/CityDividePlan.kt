package graph


/*
N: 집의 개수(Node), M : 길의 개수(Edge)
A(연결 Node), B(연결 Node), C(유지비)
7 6
1 3 2
1 6 2
2 5 2
3 2 1
6 4 1
6 7 4

2 4
1 2 4
2 1



0 1 2 3 4 5 6 7
1 0 3 2 0 5 2 0
2 3 0 1 0 2 0 0
3 2 1 0 4 0 0 6
4 0 0 4 0 3 1 0
5 5 2 0 0 0 3 0
6 2 0 0 1 3 0 4
7 0 0 6 0 0 4 0

 */

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val array = ArrayList<Triple<Int, Int, Int>>()
    repeat(M) {
        array.add(readln().split(" ").map { it.toInt() }.run {
            if (this[0] < this[1])
                Triple(this[0], this[1], this[2])
            else Triple(this[1], this[0], this[2])
        })
    }
    if (N == 2) {
        println(0)
        return
    } else if (M == N - 1) {
        println((array.sumOf { it.third } - array.maxBy { it.third }.third))
        return
    }
    array.sortBy { it.third }
    val unionMap = IntArray(N + 1) { it }
    val answer = mutableListOf<Int>()
    array.forEach { triple ->
        if (unionNode(unionMap, triple.first, triple.second)) {
            answer.add(triple.third)
        }
    }
    println(answer.sum() - answer.maxOrNull()!!)
}

private fun getParent(nodes: IntArray, value: Int): Int =
    if (nodes[value] == value) {
        value
    } else {
        nodes[value] = getParent(nodes, nodes[value])
        nodes[value]
    }

private fun unionNode(nodes: IntArray, first: Int, second: Int): Boolean {
    val firstValue = getParent(nodes, first)
    val secondValue = getParent(nodes, second)
    if (firstValue == secondValue) return false
    if (firstValue > secondValue)
        nodes[firstValue] = secondValue
    else
        nodes[secondValue] = firstValue
    return true
}
