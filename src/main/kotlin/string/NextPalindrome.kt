package string

import java.math.BigInteger

var N = readln().toBigInteger().plus(BigInteger.ONE).toString().map {
    it.digitToInt()
}.toMutableList()

fun main() {
    if (N.size == 1) {
        print(N[0])
        return
    }
    repeat(2) {
        palindromeCheck2()
    }
    print(N.joinToString(""))
}

fun palindromeCheck2() {
    for (i in 0 until (N.size / 2) + 1) {
        if (N[i] < N[N.size - (i + 1)]) {
            ++N[N.size - (i + 2)]
        }
        N[N.size - (i + 1)] = N[i]
        for (j in N.size - 1 downTo 1) {
            if (N[j] >= 10) {
                N[j] %= 10
                N[j - 1]++
            }
        }
    }
}

//Fail
fun palindromeCheck(currentNum: String): Boolean {
    var isFound = true
    var front = 0
    var reverse = currentNum.length - 1
    while (front < reverse) {
        if (currentNum[front] != currentNum[reverse]) {
            isFound = false
            break
        }
        front++
        reverse--
    }
    return isFound
}