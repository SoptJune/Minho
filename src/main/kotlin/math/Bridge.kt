package math

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val str = StringBuilder()
    var N = readln().toInt()
    val dp = Array(31) { IntArray(31) }
    for (i in 1 until 31) {
        dp[i][1] = i
        for (j in 2 until i) {
            dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j]
        }
        dp[i][i] = 1
    }
    for(i in N downTo 1){
        val (r, n) = readln().split(' ').map { it.toInt() }
        str.append("${dp[n][r]}\n")
    }
    bw.write(str.toString())
    bw.close()
}