package graph

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