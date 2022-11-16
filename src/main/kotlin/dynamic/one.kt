package dynamic

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val array = IntArray(n + 1)
    if (n < 4) {
        if(n==1) println(0)
        else println(1)
    } else {
        array[1] = 0
        array[2] = 1
        array[3] = 1
        for (i in 4..n) {
            if (i % 6 == 0) {
                array[i] = minOf(array[i / 2], array[i - 1], array[i / 3]) + 1
            } else if (i % 2 == 0) {
                array[i] = min(array[i / 2], array[i - 1]) + 1
            } else if (i % 3 == 0) {
                array[i] = min(array[i / 3], array[i - 1]) + 1
            } else {
                array[i] = array[i - 1] + 1
            }
        }
        println(array[n])
    }
}