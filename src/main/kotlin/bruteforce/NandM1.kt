package bruteforce

/*
    백준 15649번 N과 M(1), 순열과 조합
    N과 M이 주어졌을 때, 아래 조건을 만족하는 길이가 M인 수열을 모두 구하는 프로그램을 작성하시오.
    한 줄에 하나씩 문제의 조건을 만족하는 수열을 출력한다. 중복되는 수열을 여러 번 출력하면 안되며,
    각 수열은 공백으로 구분해서 출력해야 한다.
    수열은 사전 순으로 증가하는 순서로 출력해야 한다.
    근데 이건 순열과 조합 다시 풀어야할듯?
 */

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