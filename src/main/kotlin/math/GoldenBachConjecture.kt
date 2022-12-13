package math

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import kotlin.math.abs

/*
    백준 9020번 "골드바흐의 추측" (실버 2)
    https://www.acmicpc.net/problem/9020
 */

fun main() {
    val primeMap = BooleanArray(10_001)
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val str = StringBuilder()
    primeMap[1] = true
    for (i in 2..100) {
        if (primeMap[i]) continue
        for (j in i * i..10_000 step (i)) {
            primeMap[j] = true
        }
    }
    val T = readln().toInt()
    repeat(T) {
        val value = readln().toInt()
        var diff = Triple(0, 0, Int.MAX_VALUE)
        for (i in 1 until value) {
            if (!primeMap[i] && !primeMap[value - i]) {
                if (diff.third > abs((value - i) - i)) {
                    diff = Triple(i, value - i, (value - i) - i)
                }
            }
        }
        str.append("${diff.first} ${diff.second}\n")
    }

    bw.write(str.toString())
    bw.close()
}