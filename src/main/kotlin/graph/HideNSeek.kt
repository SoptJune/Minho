package graph

import java.lang.Math.min
import java.util.*
import kotlin.math.log2
/*
    백준 1697번 (숨바꼭질)
    BFS 풀이
    동생이 더 뒤에 있으면 N - K값이 정답
    수빈이가 동생의 위치에서 2의 거듭제곱 위치에 있을 경우에는 저런 짓을 한다.
    아니면 앞으로, 뒤로, X 2로 이동 했을 때 min 횟수를 기입해준다. 방문한 곳은 false
 */

const val MAX_MOVE = 100_000
val visit = IntArray(100_001)
fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }

    if (N >= K) {
        print(N - K)
        return
    } else if (N != 0 && K % N == 0) {
        if (log2((K / N).toDouble()) == log2((K / N).toDouble()).toInt().toDouble()) {
            print(log2((K / N).toDouble()).toInt())
            return
        }
    }
    bfs(N, K)
    println(visit[K])
}

fun bfs(N: Int, K: Int) {
    val queue = LinkedList<Int>()
    queue.add(N)
    visit[N] = 0
    while (queue.isNotEmpty()) {
        val data = queue.poll()
        val arr = intArrayOf(data - 1, data + 1, data * 2)
        arr.forEach { index ->
            if (index in 0..MAX_MOVE) {
                if (visit[index] == 0) {
                    queue.add(index)
                    visit[index] = visit[data] + 1
                } else if (index == K) {
                    visit[index] = min(visit[data] + 1, visit[index])
                }
            }
        }
    }
}