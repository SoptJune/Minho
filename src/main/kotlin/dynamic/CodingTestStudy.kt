package dynamic

import kotlin.math.min

fun main() {
    /*println("Solution  ${solution(10, 10, arrayOf(intArrayOf(10, 15, 2, 1, 2), intArrayOf(20, 20, 3, 3, 4)))}")*/
    println(
        "Solution  ${
            solution(
                0,
                0,
                arrayOf(
                    intArrayOf(0, 0, 2, 1, 2),
                    intArrayOf(4, 5, 3, 1, 2),
                    intArrayOf(4, 11, 4, 0, 2),
                    intArrayOf(10, 4, 0, 4, 2)
                )
            )
        }"
    )
}

data class AlgorithmProblem(val alpReq: Int, val copReq: Int, val alpRwd: Int, val copRwd: Int, val cost: Int)

fun solution(alp: Int, cop: Int, problems: Array<IntArray>): Int {
    var answer: Int = 0
    var realAlp = alp
    var realCop = cop
    val algorithmProblem = problems.map { AlgorithmProblem(it[0], it[1], it[2], it[3], it[4]) }
    val endAlp = algorithmProblem.maxOf { it.alpReq }
    val endCop = algorithmProblem.maxOf { it.copReq }
    if (endAlp <= alp && endCop <= cop) {
        return 0
    }
    if (endAlp <= alp) {
        realAlp = endAlp
    }
    if (endCop <= cop) {
        realCop = endCop
    }
    val array = Array(endAlp + 2) {
        IntArray(endCop + 2) {
            Int.MAX_VALUE
        }
    }
    array[realAlp][realCop] = 0
    for (i in realAlp..endAlp) {
        for (j in realCop..endCop) {
            array[i + 1][j] = min(array[i + 1][j], array[i][j] + 1)
            array[i][j + 1] = min(array[i][j + 1], array[i][j] + 1)
            for (problem in algorithmProblem) {
                if (i >= problem.alpReq && j >= problem.copReq) {
                    if (i + problem.alpRwd > endAlp && j + problem.copRwd > endCop) {
                        array[endAlp][endCop] = min(array[endAlp][endCop], array[i][j] + problem.cost)
                    } else if (i + problem.alpRwd > endAlp) {
                        array[endAlp][j + problem.copRwd] =
                            min(array[endAlp][j + problem.copRwd], array[i][j] + problem.cost)
                    } else if (j + problem.copRwd > endCop) {
                        array[i + problem.alpRwd][endCop] =
                            min(array[i + problem.alpRwd][endCop], array[i][j] + problem.cost)
                    } else if (i + problem.alpRwd <= endAlp && j + problem.copRwd <= endCop) {
                        array[i + problem.alpRwd][j + problem.copRwd] =
                            min(array[i + problem.alpRwd][j + problem.copRwd], array[i][j] + problem.cost)
                    }
                }
            }
        }
    }
    return array[endAlp][endCop]
}

/*
현재 alp, cop로 풀 수 있는 문제가 없을 때, 최소 점수까지 계속 공부함.

풀 수 있는 문제가 있을 때, 비용이 제일 큰 문제부터 ( 어차피 모든 문제 풀어야함 )

업데이트 다 한다.
최종 문제를 가려낸다. 알고력, 코딩력이 같을 때는 비용이 큰게 제일 마지막
 */