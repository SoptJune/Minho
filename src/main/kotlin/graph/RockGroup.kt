package graph

import java.util.LinkedList

fun main() {
    val (A, B, C) = readln().split(" ").map { it.toInt() }
    var total = (A + B + C)
    if (total % 3 != 0) {
        println(0)
        return
    }
    val visitArray = Array<IntArray>(total + 1) {
        IntArray(total + 1)
    }
    val queue = LinkedList<Pair<Int, Int>>()
    queue.offer(A to B)
    visitArray[A][B] = 1
    searchThreeCount(total, visitArray, queue)
    println(visitArray[total / 3][total / 3])
}

fun searchThreeCount(total: Int, visitArray: Array<IntArray>, queue: LinkedList<Pair<Int, Int>>) {
    while (queue.isNotEmpty()) {
        val (A, B) = queue.poll()
        val countList = listOf(A, B, total - (A + B))
        for (i in 0 until 3) {
            for (j in 0 until 3) {
                if (countList[i] < countList[j]) {
                    val temp1 = countList[i] * 2
                    val temp2 = countList[j] - countList[i]
                    if (visitArray[temp1][temp2] != 1) {
                        visitArray[temp1][temp2] = 1
                        queue.offer(temp1 to temp2)
                    }
                }
            }
        }
    }
}