package greedy

import java.io.BufferedReader
import java.io.InputStreamReader

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