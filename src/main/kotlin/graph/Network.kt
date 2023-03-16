package graph

/*
    프로그래머스 네트워크
    DFS 풀이
    네트워크 몇개인지 물어보는 것
 */

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

private fun dfs(index: Int) {
    networkMap[index] = true
    for (i in 1 until network.size) {
        if (index != i && network[index][i] == 1 && !networkMap[i]) {
            dfs(i)
        }
    }
}

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