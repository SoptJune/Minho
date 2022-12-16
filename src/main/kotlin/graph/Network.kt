package graph

private lateinit var networkMap: BooleanArray
private lateinit var network: Array<IntArray>
fun main() {
    val array = arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1))
    print(solution(3, array))
}

private fun solution(n: Int, computers: Array<IntArray>): Int {
    networkMap = BooleanArray(n + 1)
    var answer = 0
    network = Array(n + 1) {
        IntArray(n + 1)
    }
    computers.forEachIndexed { j, ints ->
        ints.forEachIndexed { i, value ->
            network[j + 1][i + 1] = value
        }
    }
    for (i in 1..computers.size) {
        if (!networkMap[i]) {
            dfs(i)
            answer++
        }
    }
    return answer
}

fun dfs(index: Int) {
    networkMap[index] = true
    for (i in 1 until network.size) {
        if (index != i && network[index][i] == 1 && !networkMap[i]) {
            dfs(i)
        }
    }
}

/*

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
*/

/*

0 1 2 3
1 1 1 0
2 1 1 0
3 0 0 1

0 1 2 3
1 1 1 0
2 1 1 1
3 0 1 1



 */