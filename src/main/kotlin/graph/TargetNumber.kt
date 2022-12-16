package graph

/*
    프로그래머스 타겟넘버
    +했을 때, - 했을 때로 완전탐색 돌려서 Target이 되는 경우에만 count++
 */

private var sum = 0
private var count = 0
private lateinit var numberList: IntArray
fun main() {
    println(solution(intArrayOf(4, 1, 2, 1), 4))
}

private fun solution(numbers: IntArray, target: Int): Int {
    numberList = numbers
    dfs(0, numbers.size, 0, target)
    return count
}

private fun dfs(depth: Int, n: Int, sum: Int, target: Int) {
    if (depth == n) {
        if (sum == target) {
            count++
        }
    } else {
        dfs(depth + 1, n, sum + numberList[depth], target)
        dfs(depth + 1, n, sum - numberList[depth], target)
    }
}