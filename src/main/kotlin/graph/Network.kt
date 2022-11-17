package graph

import java.util.*

var networkVertex = BooleanArray(201)
val networkGraph: Array<LinkedList<Int>?> = arrayOfNulls(201)
var isSpanning = false
fun main() {
    val array = arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 1), intArrayOf(0, 1, 1))
    print(solution(3, array))
}

fun solution(n: Int, computers: Array<IntArray>): Int {
    for (i in 1..n) {
        networkGraph[i] = LinkedList<Int>()
    }
    var networkCount = 0

    val data = computers.mapIndexed { targetIndex, computer ->
        computer[targetIndex] = 0
        computer.mapIndexed { destinationIndex, peer ->
            if (peer == 1) {
                computers[destinationIndex][targetIndex] = 0
                Pair(targetIndex, destinationIndex)
            } else null
        }.filterNotNull()
    }.flatten()
    data.forEach { pair ->
        val (targetValue, destinationValue) = pair
        networkGraph[targetValue + 1]?.add(destinationValue + 1)
    }

    for (i in 1..n) {
        isSpanning = false
        if (!networkVertex[i]) {
            networkVertex[i] = true
            networkDFS(i, 0)
            if (!isSpanning) {
                networkCount++
            }
        }
    }
    return if (networkCount == 0) 1 else networkCount
}

fun networkDFS(cur: Int, pre: Int) {
    for (i in networkGraph[cur]!!) {
        if (networkVertex[i]) {
            isSpanning = true
        } else {
            networkVertex[i] = true
            networkDFS(i, cur)
        }
    }
}
