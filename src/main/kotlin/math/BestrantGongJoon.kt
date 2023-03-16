package math

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import kotlin.math.sqrt

/*
    백준 4948번 "베르트랑 공준" ( 실버 2 )
    https://www.acmicpc.net/problem/4948
    n보다 크고 2n보다 작은 소수의 개수 출력
    에네토스체네스의 체?
 */

fun main() {
    val primeMap = BooleanArray(246_912 + 1)
    primeMap[1] = true
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val str = StringBuilder()
    for (i in 2..sqrt((246_912).toDouble()).toInt()) {
        if (primeMap[i]) {
            continue
        }
        for (j in i * i..246_912 + 1 step (i)) {
            primeMap[j] = true
        }
    }
    while (true) {
        val value = readln().toInt()
        if (value == 0) {
            break
        }
        str.append("${primeMap.filterIndexed { index, b -> index <= value * 2 && !b }.size - primeMap.filterIndexed { index, b -> index <= value && !b}.size}\n")
    }
    bw.write(str.toString())
    bw.close()
}
