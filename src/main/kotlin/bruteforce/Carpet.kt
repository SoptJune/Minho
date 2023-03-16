package bruteforce

/*
    프로그래머스 카펫
    완탐도 아님, 그냥 Return 은 최소 3, 3이상이다
    그리고 앞이 더 커야 해서 만들어질 수 있는 경우의 절반만 탐색
    ex: 48은, 16 * 3, 8 * 6 까지만 검사(3보다 큰 경우와 3*16이런건 검사 안함)
 */

fun main() {
    println(solution(10, 2).toList())
}


private fun solution(brown: Int, yellow: Int): IntArray {
    val sum = brown + yellow
    for (i in 3..(sum / 3)) {
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