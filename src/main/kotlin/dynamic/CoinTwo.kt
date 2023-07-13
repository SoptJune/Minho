package dynamic

fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }

    val travelMap = MutableList<Int>(K + 1) {
        10_001
    }.toMutableList()
    val array = Array(N) {
        readln().toInt()
    }.filter { it <= K }.also { list ->
        list.forEach {
            travelMap[it] = 1
        }
    }.sortedDescending()
    if (array.isEmpty()) {
        println(-1)
        return
    }
    if (array.first() == K) {
        println(1)
        return
    }
    array.forEach { element ->
        for (i in element..K) {
            travelMap[i] = travelMap[i].coerceAtMost(travelMap[i - element] + 1)
        }
    }
    if (travelMap[K] == 10_001) {
        println(-1)
    } else {
        println(travelMap[K])
    }
}

/*
Test Case
3 15
1
5
12

Idea
15크기의 배열을 만든다.
1~15까지 해당 가치를 만들 수 있는 최소 동전 갯수를 판별한다.
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
  1       1                1
로 시작, 1원부터 돌린다.

0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
  1 2 3 4 1 2 3 4 5 6  7  1  2  3  4

5원 돌린다.

0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
  1 2 3 4 1 2 3 4 5 2  3  1  2  3  3

ㄴㄴ 역순으로 다시 ㄱㄱ

1~15까지 해당 가치를 만들 수 있는 최소 동전 갯수를 판별한다.
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
  1       1                1
로 시작, 12원부터 돌린다. (그대로)

5원 돌린다.
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
  1       1         2      1       3

1원 돌린다.
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15
  1 2 3 4 1 2 3 4 5 2  3  1  2  3  3
*/