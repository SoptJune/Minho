package math

/*
    백준 4375번 1 (실버 3)
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