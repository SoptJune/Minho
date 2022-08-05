package greedy

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var cnt = 1
    while (true) {
        val (l, p, v) = readLine().split(' ').map { it.toInt() }
        if (l == 0 && p == 0 && v == 0) {
            break
        } else {
            val day = if (v % p < l) v % p else l
            println("Case ${cnt++}: ${(v / p) * l + day}")
        }
    }
}