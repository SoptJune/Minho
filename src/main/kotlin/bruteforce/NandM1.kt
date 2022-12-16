package bruteforce

import java.io.BufferedReader
import java.io.InputStreamReader

private fun combination(data: MutableList<Int>, list: List<Int>, state: Array<Boolean>, start: Int, m: Int, n: Int) {
    if (m == start) {
        println(data.joinToString(" "))
    } else {
        for (i in 0..n - 1) {
            if (!state[i]) { // 본인 제외
                state[i] = true
                data.add(i + 1)  //이차원 배열로 하려했는데 안 된다...
                combination(data, list, state, start + 1, m, n)
                state[i] = false
                data.removeAt(data.lastIndex)
            }
        }
    }
}

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val (n, m) = readLine().split(' ').map { it.toInt() }
    val list = mutableListOf<Int>().apply {
        for (i in 1..n) {
            add(i)
        }
    }
    combination(mutableListOf<Int>(), list, Array<Boolean>(list.size) { false }, 0, m, n)
}