package dynamic

import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

/*
    백준 1463번 (1로 만들기)
    1. X가 3으로 나누어 떨어지면, 3으로 나눈다.
    2. X가 2로 나누어 떨어지면, 2로 나눈다.
    3. 1을 뺀다.
    1, 2가 충족하는 경우 1, 2, 3 케이스에 대해서 다 비교
    1, 2 둘 다 충족 안하면 3번만
    1 or 2 충족하면 3번과도 비교
 */

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val n = readLine().toInt()
    val array = IntArray(n + 1)
    if (n < 4) {
        if (n == 1) println(0)
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
/*
0 1 1 2 3 2 3
 */