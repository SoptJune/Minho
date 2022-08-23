package graph

import java.util.*

var vertex = BooleanArray(501)
val graph: Array<LinkedList<Int>?> = arrayOfNulls(501)
var flag = false

fun depthFirstSearch(cur: Int, pre: Int) {
    for (i in graph[cur]!!) {
        if (vertex[i]) {
            if (i != pre) flag = true // Cycle Exist
        } else {
            vertex[i] = true
            depthFirstSearch(i, cur)
        }
    }
}

fun main() {
    var testCase = 1
    while (true) {
        val (n, m) = readln().split(' ').map { it.toInt() }
        if (n == 0 && m == 0) break
        var treeCount = 0
        vertex = BooleanArray(501)
        for (i in 0..n) {
            graph[i] = LinkedList<Int>()
        }
        //Initialize Value
        repeat(m) {
            val (targetValue, destinationValue) = readln().split(' ').map { it.toInt() }
            graph[targetValue]?.add(destinationValue)
            graph[destinationValue]?.add(targetValue)
        }
        for (i in 1..n) {
            flag = false
            if (!vertex[i]) {
                vertex[i] = true
                depthFirstSearch(i, 0) // Check Spanning Tree
                if (!flag) {  // Find Spanning Tree
                    treeCount++
                }
            }
        }
        if (treeCount > 1) {
            println("Case $testCase: A forest of $treeCount trees.")
        } else if (treeCount == 1) {
            println("Case $testCase: There is one tree.")
        } else {
            println("Case $testCase: No trees.")
        }
        testCase++
    }
}
