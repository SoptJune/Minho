package backtracking

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.abs

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