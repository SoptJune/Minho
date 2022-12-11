package dynamic

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val (N, M) = readln().split(" ").map { it.toInt() }
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val str = StringBuilder()
    val array = mutableListOf<Int>(0)
    array.addAll(readln().split(" ").map { it.toInt() }.toMutableList())
    for (i in 1 until array.size) {
        array[i] += array[i - 1]
    }
    val command = mutableListOf<Pair<Int, Int>>()
    repeat(M) {
        command.add(readln().split(" ").map { it.toInt() }.run { Pair(this[0], this[1]) })
    }
    command.forEach {
        str.append("${array[it.second] - array[it.first-1]}\n")
    }
    bw.write(str.toString())
    bw.close()
}

/*
1,000 * 100,000
100_000_000
21억


10 6
10 9 8 7 6 5 4 3 2 1
[1][1] = 10
[1][2] = 19
[1][3] = 27
[1][4] = 34
[1][5] = 40
[1][6] = 45
[1][7] = 49
1 7
[1][4] =
1 4
1 3
[2][1]=
2 4
5 9
5 5



 */