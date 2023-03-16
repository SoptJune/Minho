package math

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import kotlin.math.roundToInt
import kotlin.math.sqrt

fun main() {
    val G = readln().toInt()
    val maxA = ((G + 1).toDouble() / 2).roundToInt()  //최대가 될 수 있는 현재 몸무게
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val stringBuilder = StringBuilder()
    var A = G.sqrt()    //현재 몸무게 예상
    var B = 1           //망상 속 몸무게 예상
    while (A <= maxA) {
        if (A == B) {   //G가 1부터 있는 이상 같을 수는 없음
            A++
            B = 1
        } else if (A.pow() - B.pow() == G) {  //찾은 경우
            stringBuilder.append("$A\n")
            A++
            B = 1
        } else {        //못 찾은 경우 망상속은 더 찐 상태
            B++
        }
    }
    if (stringBuilder.isBlank()) {   //없는 경우 수고
        bw.write("-1")
    } else {
        bw.write(stringBuilder.toString())
    }
    bw.close()
}

fun Int.sqrt(): Int {
    return sqrt(this.toDouble()).roundToInt()
}

fun Int.pow(): Int = this * this

/*

15키로 쪘다고 헀을 때
15 = (현재 될 수 있는 몸무게 : A)^2 - (망상속 몸무게 : B)^2

A : 4 일 때 B : 1
A : 8 일 때 B : 7

A^2 - B^2 = G가 되는 값 찾기

G + B^2 = A^2인 값 찾기

G <= 100_000

N이 증가하면서 찾음
A(N^2) - B((N-1)^2) > G 인 순간부터 멈추면 될 듯

G = 100_000일 때,
A(N^2) - B((N-1)^2) <= G
의 최대는
50_000^2 - 49_999^2 = 9_999

50_001^2 - 50_000^2 = 10_001

G가 10_001의 경우는 없으니 N의 최대는 50_000

G가 주어질 때 최대 N값은
N^2 - (N-1)^2 = G
2N - 1 = G
N = (G + 1)/2

A = sqrt(G)
100_000
 */