package bruteforce

import graph.ans
import kotlin.math.min

fun main() {
    /*println(
        solution(
            arrayOf(
                "DIA",
                "RUBY",
                "RUBY",
                "DIA",
                "DIA",
                "EMERALD",
                "SAPPHIRE",
                "DIA"
            )
        ).toList()
    )*/
    /*println(
        solution(
            arrayOf("AA","AB", "AC", "AA", "AC"
            )
        ).toList()
    )*/
    /*println(
        solution(
            arrayOf("XYZ","XYZ", "XYZ"
            )
        ).toList()
    )*/
    println(
        solution(
            arrayOf("ZZZ","YYY", "NNNN","YYY","BBB"
            )
        ).toList()
    )
}

fun solution(gems: Array<String>): IntArray {
    val answer = gems.toSet()
    val transform = HashMap<String, Int>()

    var start = 0
    if (answer.size==1){
        return intArrayOf(1, 1)
    }else if (answer.size == gems.size){
        return intArrayOf(1, gems.size)
    }
    var short = Triple(Int.MAX_VALUE, 1, gems.size)
    gems.forEachIndexed { index, gem ->
        transform[gem] = transform[gem]?.plus(1) ?: 1
        if (transform.size == answer.size) {
            var findIndex = start
            while (true) {
                if (transform.size != answer.size) {
                    if (short.third > (index + 1) - findIndex) {
                        short = Triple(findIndex, index + 1, (index + 1) - findIndex)
                    }
                    break
                } else {
                    if (transform[gems[findIndex]] == 1) {
                        transform.remove(gems[findIndex])
                    } else {
                        transform[gems[findIndex]] = transform[gems[findIndex]]?.minus(1) ?: 1
                    }
                }
                findIndex++
            }
            start = findIndex
        }
    }
    return intArrayOf(short.first, short.second)
}
/*
1 1 1 1 1 2 2 3 1 2 3


 */