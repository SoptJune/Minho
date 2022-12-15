package bruteforce

fun main() {
    println(solution(10, 2).toList())
}


private fun solution(brown: Int, yellow: Int): IntArray {
    val sum = brown + yellow
    for (i in 3 .. (sum / 3)) {
        if (sum % i == 0) {
            if (brown == (sum - ((i - 2) * (sum / i - 2)))) {
                return (intArrayOf(sum / i, i))
            }
        }
    }
    return intArrayOf()
}
/*
21019
10192
01921
19210
92102
 */