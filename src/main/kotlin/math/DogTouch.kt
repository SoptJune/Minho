package math

import kotlin.math.ceil
import kotlin.math.roundToInt
import kotlin.math.sqrt


fun main() {
    val (X, Y) = readln().split(" ").map { it.toInt() }

    if ((Y - X) <= 2) {
        println(Y - X)
        return
    }
    val diff = Y - X
    val N = ceil(sqrt(diff.toDouble())).roundToInt()
    if (N * N - N < diff) {
        println(N * 2 - 1)
    } else {
        println(N * 2 - 2)
    }
}

/*
1~N까지 합
N*(N+1)/2

1~(N-1)까지 합
(N-1)*N/2

1~N~1 까지의 합
(N*N+N + N*N - N)/2 = N * N
1~N, N~1까지 합
2*(N*N + N)/2 = N * N + N

N의 기준?? 제곱근이 딱 맞으면 편하다, 그게 아니면 N*N한거에 N빼보면 안다.
N*N+N or N*N

6, 1, 51
8, 2, 51
11, 3, 51
15, 4, 51
20, 5, 51
26, 6, 51
(25일 남음, 5로 나누면 몫은 5 나머지는 0, 6으로 나누면 몫은 4, 나머지는 1, 7로 나누면 몫은 3 나머지는 4임)
33, 7, 51
41, 8, 51
(10일 남았음, 6, 7, 8중에 선택)


5, 6, 7, 8, 9, 10
 */