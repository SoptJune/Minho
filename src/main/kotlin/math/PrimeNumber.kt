package math

import java.io.BufferedWriter
import java.io.OutputStreamWriter

/*
    백준 1929번 소수 구하기(실버 3)
 */

fun main() {
    val (M, N) = readln().split(' ').map { it.toInt() }
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val str = StringBuilder()
    val primeMap = BooleanArray(1_000_001)
    primeMap[1] = true
    for (i in 2..1_000) {
        if (primeMap[i]) {
            continue
        }
        for (j in i * i..1_000_000 step (i)) {
            primeMap[j] = true
        }
    }
    for (i in M..N) {
        if (!primeMap[i]) {
            str.append("$i\n")
        }
    }
    bw.write(str.toString())
    bw.close()
}