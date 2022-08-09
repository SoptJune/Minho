package string

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val P = readln()
    val S = readln()
    val hash = S.hashCode()
    for (i in 0..(P.length - S.length)) {
        if (hash == P.substring(i, S.length + i).hashCode()) {
            println(1)
            return@with
        }
    }
    println(0)
}
