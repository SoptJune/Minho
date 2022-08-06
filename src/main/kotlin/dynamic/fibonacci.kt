package dynamic

import java.io.BufferedReader
import java.io.InputStreamReader


fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    println("${fibo(n, 1, 0)} ${n-2}")
}

tailrec fun fibo(n: Int, previousNum: Int, nextNum: Int): Int {

    if (n == 0) return nextNum
    if (n == 1) return previousNum
    return fibo(n - 1, previousNum + nextNum, previousNum)
}