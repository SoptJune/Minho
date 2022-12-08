package math

/*
    백준 6588번 골드바흐의 추측 (실버 1)
 */

fun main() {
    val primeMap = BooleanArray(1_000_001)
    primeMap[1] = true
    for (i in 2..1_000) {
        if (primeMap[i]) {
            continue
        }
        for (j in i * i..1_000_000 step (i)) {
            primeMap[j] = true
        }
    }
    while (true) {
        val case = readln().toInt()
        var endNum = case
        if (case == 0) {
            break
        }
        while (true) {
            while (primeMap[endNum]) endNum--
            if (!primeMap[case - endNum] && endNum + (case - endNum) == case) {
                println("$case = ${case - endNum} + $endNum")
                break
            } else if (endNum <= 2) {
                println("Goldbach's conjecture is wrong.");
                break
            } else {
                endNum--
            }
        }
    }
}