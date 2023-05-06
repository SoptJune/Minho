package datastructure

import java.util.*

fun main() {
    val N = readln().toInt()
    val stack = Stack<List<Int>>()

    val array = Array(N) {
        stack.add(readln().split(" ").map { it.toInt() })
    }
    var timeSum = 0
    var scoreSum = 0
    while (!stack.empty()) {
        val data = stack.pop()
        if (data.first() == 0) {
            timeSum++
            continue
        }
        if (data[2] - 1 == 0) {
            scoreSum += data[1]
        } else {
            if (timeSum - (data[2] - 1) >= 0) {
                timeSum -= (data[2] - 1)
                scoreSum += data[1]
            } else {
                timeSum = 0
            }
        }
    }
    println(scoreSum)
}

/*
뒤에서부터 검사
0이면 timeSum + 1
1이면 3번째꺼 -1 해주고, 0인지 검사
 - 0이면 2번째 값 scoreSum 누적
 - 양수면 timeSum에다가 빼줌
   - 이게 음수면 timeSum 0으로 바꾸고 점프
   - 0 또는 양수면 2번째 값 scoreSum 누적
stack이 empty일 때까지 계속
 */