package graph

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.lang.StringBuilder

private data class Student(val num: Int, var target: IntArray, var count: Int = 0)

fun main() {
    val N = readln().toInt()
    val listQueue = Array<Student>(N) {
        Student(it + 1, IntArray(2))
    }
    val str = StringBuilder()
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val visit = BooleanArray(N + 1)
    visit[0] = true
    repeat(N) { index ->
        val (first, second) = readln().split(" ").map { it.toInt() }
        listQueue[index].target = intArrayOf(first, second)
        listQueue[first - 1].count++
        listQueue[second - 1].count++
    }
    var removeCount = 0
    val data = listQueue.filter { it.count < 2 }.toMutableList()
    while (data.isNotEmpty()) {
        val front = data.removeFirst()
        removeCount++
        visit[front.num] = true
        val (first, second) = front.target
        listQueue[first - 1].count--
        listQueue[second - 1].count--
        if (listQueue[first - 1].count == 1) {
            data.add(listQueue[first - 1])
        }
        if (listQueue[second - 1].count == 1) {
            data.add(listQueue[second - 1])
        }
    }
    str.append("${N - removeCount}\n")
    visit.forEachIndexed { index, b ->
        if (!b) {
            str.append("${index} ")
        }
    }
    bw.write(str.toString())
    bw.close()
}

/*
1, 2, 3,         4,     5
2, 2, (1, 4), ,  (2, 3, 4)


현재 번호, 준 선물, 받은 선물
받은 선물.size < 2 일 때, 준 선물들 회수



4(3, 5)
 */