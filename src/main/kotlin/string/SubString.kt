package string

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val S = readln()
    val P = readln()
    val table = makePi(P)
    var j = 0
    for (i in S.indices) {
        while (j > 0 && S[i] != P[j])
            j = table[j - 1]
        if (P[j] == S[i]) {
            if (j == P.length - 1) {
                println(1)
                return@with
            } else {
                j++
            }
        }
    }
    println(0)

    val hash = P.hashCode()

    for (i in 0..(S.length - P.length)) {
        if (hash == S.substring(i, P.length + i).hashCode()) {
            println(1)
            return@with
        }
    }
    println(0)

    if (S.contains(P)) {
        println(1)
    } else {
        println(0)
    }
}

fun makePi(str: String): IntArray {
    var j = 0
    val pi = IntArray(str.length)

    for (i in 1 until str.length) {
        while (j > 0 && str[i] != str[j])
            j = pi[j - 1]
        if (str[i] == str[j]) pi[i] = ++j
    }
    return pi
}