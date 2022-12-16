package greedy

import java.io.BufferedReader
import java.io.InputStreamReader

/*
    백준 10610번 (30)
    그리디도 아님
    30의 배수면 1의 자리는 0, 자리수의 합이 3의 배수면 10의 배수이다.
 */
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val str = readLine().toCharArray().sortedArrayDescending().joinToString("")
    var sum = 0
    str.forEach {
        sum += it.digitToInt()
    }
    if (str.last() == '0' && sum % 3 == 0) {
        println(str)
    } else {
        println("-1")
    }
}