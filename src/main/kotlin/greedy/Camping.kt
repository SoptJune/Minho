package greedy

import java.io.BufferedReader
import java.io.InputStreamReader

/*
    백준 4796번 (캠핑)
    그리디 풀이
    캠핑장은 연속하는 20일 중 10일동안만 사용할 수 있습니다.
    캠핑장을 연속하는 P일 중, L일동안만 사용할 수 있다.
    강산이는 이제 막 V일짜리 휴가를 시작했다.
    강산이가 캠핑장을 최대 며칠동안 사용할 수 있을까? (1 < L < P < V)
    나누기 연산을 하는 것
 */

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