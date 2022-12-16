package dynamic
/*
    백준 "동전1" ( 골드 5 )
    DP문제
    동전에 따른 K 가치가 되는 경우의 수를 뽑아내는 것
    가치의 min부터~k까지의 경우의 수를 계속 구한당
 */

fun main() {
    val (N, K) = readln().split(" ").map { it.toInt() }
    val array = IntArray(K + 1)
    val costArray = mutableListOf<Int>()
    repeat(N) {
        val cost = readln().toInt()
        costArray.add(cost)
    }
    array[0] = 1
    costArray.forEach { cost ->
        for (i in cost..K) {
            array[i] = array[i] + array[i - cost]
        }
    }
    println(array[K])
}

/*
100
  1 2 3 4 5   6  7  8  9  10
0 1 1 0 0 1   0  0  0  0  1
0 1 2 3 5 13


1111
112
121
211
22

11111
1112
1121
1211
2111
113
131
311
122
212
221
32
23

6 + 3
A(4) + 1
A(3) + 2

1, 2, 5
 */