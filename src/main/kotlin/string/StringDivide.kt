package string

fun main() {
    println(solution("aaabbaccccabba"))
}

private fun solution(s: String): Int {

    var answer = s.first()
    var tempCount = 0
    var answerCount: Int = 1
    var eachCount = 1
    if (s.length == 1) {
        return 1
    }
    for (i in 1 until s.length) {

        if (answerCount == tempCount) {
            eachCount++
            answer = s[i]
            answerCount = 1
            tempCount = 0
        } else if (s[i] == answer) {
            answerCount++
        } else {
            tempCount++
        }
    }
    return eachCount
}

/*
aabbaabb
aba
 */