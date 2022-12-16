package math

/*
    백준 4375번 1 (실버 3)
    2와 5로 나누어 떨어지지 않는 정수 n(1 ≤ n ≤ 10000)가 주어졌을 때,
    1로만 이루어진 n의 배수를 찾는 프로그램을 작성하시오.
    1부터 하나씩 늘려가면서 answer으로 나눠지는지 확인한다.
    끝
 */

fun main() = with(System.`in`.bufferedReader()) {
    while (true) {
        var answer: Long = 1L
        val case = readLine() ?: break
        var count = 1
        while (true) {
            if (answer % case.toLong() == 0L) {
                println(count)
                break
            } else {
                answer %= case.toLong()
                answer = (answer * 10) + 1
                count++
            }
        }
    }
}