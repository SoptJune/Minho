package bruteforce

fun main() {
    println(solution2(intArrayOf(1,2,3,3,2)).toList())
}

private fun solution2(answers: IntArray): IntArray {
    val person1 = arrayOf(1, 2, 3, 4, 5)
    var person1Count = 0
    val person2 = arrayOf(1, 3, 4, 5)
    var person2Count = 0
    val person3 = arrayOf(3, 1, 2, 4, 5)
    var person3Count = 0
    answers.forEachIndexed { index, i ->
        if (i == person1[index % 5]) {
            person1Count++
        }
        if ((index % 2 == 0 && i == 2)) {
            person2Count++
        } else if (index % 2 != 0 && i == person2[index % 8 / 2]) {
            person2Count++
        }
        if (i == person3[if (index == 0) 0 else (index / 2) % 5]) {
            person3Count++
        }
    }
    if (person1Count == person3Count && person1Count == person2Count) {
        return intArrayOf(1, 2, 3)
    }
    val answer = IntArray(3)
    answer[0] = person1Count
    answer[1] = person2Count
    answer[2] = person3Count
    val max = answer.maxOrNull()
    return answer.mapIndexed { index, i -> i to index+1 }.filter { it.first == max }.map { it.second }.toIntArray()
}

/*
1 3 5 7 9 11 13 15 17 19 21  23
0 1 2 3 0 1  2  3  0  1  2   3

0 1 2 3 4 5 6 7 8 9 10
0 0 1 1 2 2 3 3 4 4 0

0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
2 1 2 3 2 4 2 5 2 1 2  3  2  4  2   5

 */