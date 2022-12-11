package dynamic

import kotlin.math.min
/*
    백준 RGB거리 (실버 1)
 */

fun main() {
    val N = readln().toInt()
    val room = Array(N) { mutableListOf<Int>() }
    repeat(N) { index ->
        room[index].addAll(readln().split(" ").map { it.toInt() })
    }
    for (i in 1 until N) {
        room[i][0] += min(room[i-1][1], room[i-1][2])
        room[i][1] += min(room[i-1][0], room[i-1][2])
        room[i][2] += min(room[i-1][1], room[i-1][0])
    }
    println(room[N-1].min())
}

/*
3
26 40 83

49 60 57

13 89 99


26 40 83

89 86 83

13 89 99


26

RGB
room[0][0], room[1][1], room[1][2],
room[0][1], room[1][0], room[1][2],
room[0][2], room[1][1], room[1][2],

26,

26  40   0
49 MAX MAX
13 MAX MAX

 */