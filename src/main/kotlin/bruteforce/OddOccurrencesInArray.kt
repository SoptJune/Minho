package bruteforce

/*
    Codility OddOccurrences In Array 문제, 뭐 없음
 */

fun main() {
    println(solution(intArrayOf(-1,-3)))
}

private fun solution(A: IntArray): Int {
    val data = A.toHashSet().filter { it > 0 }
    var index = 1
    println(data)
    while (index != data.size && data[index - 1] == index) index++

    return index
}