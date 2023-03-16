package dynamic

/*
    백준 15988번 ( 1, 2, 3 더하기 3)
    DP인데 괄호랑 비슷해서 그대로 풀려다가 실패
    정수 n이 주어졌을 때, n을 1, 2, 3의 합으로 나타내는
    방법의 수를 구하는 프로그램을 작성하시오.
    해당 수의 index를 1, 2, 3을 뺀 곳과 비교한다.
 */

fun main() {
    val N = readln().toInt()
    val array = mutableListOf<Int>()

    repeat(N) {
        array.add(readln().toInt())
    }
    val max = array.max()
    val sumMap = LongArray(max + 1)
    sumMap[1] = 1L
    sumMap[2] = 2L
    sumMap[3] = 4L
    for (i in 4..max) {
        for (j in 1..3) {
            sumMap[i] = (sumMap[i] + (sumMap[i - j])) % 1_000_000_009
        }
    }
    array.forEach {
        println(sumMap[it])
    }
}

/*
0  1   2   3
1  1   2   3
2  0   1   1
3  0   0   1
1

Case 1
1
Case 2
1+1
2

Case 3
1 + 1 + 1
2 + 1
1 + 2
3

Case 4

1 + 1 + 1 + 1
2 + 1 + 1
1 + 2 + 1
3 + 1
1 + 2 + 1
1 + 1 + 2
1 + 3
2 + 2

Case 5

1 + 1 + 1 + 1 + 1
2 + 1 + 1 + 1
1 + 2 + 1 + 1
1 + 1 + 2 + 1
1 + 1 + 1 + 2
3 + 1 + 1
1 + 3 + 1
1 + 1 + 3
2 + 2 + 1
2 + 1 + 2
1 + 2 + 2
3 + 2
2 + 3

 */