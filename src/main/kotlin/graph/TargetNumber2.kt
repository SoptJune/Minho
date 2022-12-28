package graph

import kotlin.properties.Delegates

private lateinit var numberList: IntArray
private var targetNum by Delegates.notNull<Int>()
private var count = 0
fun main() {
    solution(intArrayOf(4,1,2,1), 20)
}

private fun solution(numbers: IntArray, target: Int): Int {
    numberList = numbers
    targetNum = target
    search(0, 0)
    println(count)
    return 0
}

private fun search(depth: Int, sum: Int) {
    if (depth == numberList.size) {
        if (sum == targetNum) {
            count++
        }
    } else {
        search(depth + 1, sum + numberList[depth])
        search(depth + 1, sum - numberList[depth])
    }
}