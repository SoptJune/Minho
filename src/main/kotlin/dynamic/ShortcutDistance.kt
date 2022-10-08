package dynamic

import java.lang.Math.min

var N = 0
var D = 0

var visit = IntArray(0)
var array = ArrayList<Triple<Int, Int, Int>>()
fun main() {
    val (tempN, tempD) = readln().split(" ").map { it.toInt() }
    N = tempN
    D = tempD
    if (N == 0) {
        print(D)
        return
    }
    visit = IntArray(D + 1) { it }
    repeat(N) {
        readln().split(" ").map { it.toInt() }.let {
            if (it[1] <= D && it[2] <= D && it[1] - it[0] >= it[2])
                array.add(Triple(it[0], it[1], it[2]))
        }
    }

    val comparator: Comparator<Triple<Int, Int, Int>> =
        compareBy<Triple<Int, Int, Int>> { it.first }.thenBy { it.second }.thenByDescending { it.third }

    array.sortWith(comparator)
    for (i in visit.indices) {
        if(i>0) visit[i] = min(visit[i], visit[i - 1] + 1)
        array.filter { it.first == i && (visit[i] + it.third) < visit[it.second] }.forEach {
            visit[it.second] = visit[it.first] + it.third
        }
    }
    print(visit[D])
}