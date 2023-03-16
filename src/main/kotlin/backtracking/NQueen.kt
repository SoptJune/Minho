package backtracking

import kotlin.math.abs

/*
    ### BackTracking
    N-Queen 문제는 크기가 N × N인 체스판 위에
    퀸 N개를 서로 공격할 수 없게 놓는 문제이다.

    풀이 : 하나씩 두고, 나머지 위치에 몇개 둘 수 있는지 체크한다.
    이차원 배열을 할 필요가 없음 어차피 직선은 막히니, index로 체크

 */

val table = IntArray(15)
var count = 0
val N by lazy { readln().toInt() }

fun main() {
    N
    queen(0)
    println(count)
}

fun queen(col: Int) {
    if (N == col) count++
    for (i in 0 until N) {
        table[col] = i
        if (promisingCheck(col)) queen(col + 1)
    }
}

fun promisingCheck(col: Int): Boolean {
    for (i in 0 until col) {
        if (table[i] == table[col] || col - i == abs(table[col] - table[i]))
            return false
    }
    return true
}