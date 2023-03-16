package math

import java.io.BufferedWriter
import java.io.OutputStreamWriter
/*
    백준 1010번 (다리 놓기)
    DP 풀이
    N, M개의 다리가 있을 때 N-1, M-1개의 다리가 있을 때와 N-1, M개의 다리가 있을 때를 더하면 된다.

    재원이는 서쪽의 사이트와 동쪽의 사이트를 다리로 연결하려고 한다.
    (이때 한 사이트에는 최대 한 개의 다리만 연결될 수 있다.)
    재원이는 다리를 최대한 많이 지으려고 하기 때문에 서쪽의 사이트 개수만큼 (N개) 다리를 지으려고 한다.
    다리끼리는 서로 겹쳐질 수 없다고 할 때 다리를 지을 수 있는 경우의 수를 구하는 프로그램을 작성하라.

 */

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