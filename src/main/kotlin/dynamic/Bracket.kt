package dynamic

/*
    백준 10422번 괄호 (골드 4)
 */

fun main() {

    val bracket = LongArray(5_001)
    bracket[0] = 1L
    bracket[2] = 1L

    for (i: Int in 3..5000) {
        for (j: Int in 2..i) {
            bracket[i] += bracket[j - 2] * bracket[i - j]
            bracket[i] %= 1_000_000_007L
        }
    }
    val N = readln().toInt()

    repeat(N) {
        println(bracket[readln().toInt()])
    }
}

/*
case 2
()
1
case 4
()(), (())
2
case 6
1 * case 4
case 2 * case 2
case 4 * 1

()()(), ()(()), (())(), ((())), (()())
case 8
1 * case 6
5
case 2 * case 4
2
case 4 * case 2
2
case 6 * 1
5

()()()(), ()()(()), ()(())(), ()((())), ()(()()),
(())()(), ((()))(), (()())(), (())(()),
(()()()), (()(())), ((())()), (((()))), ((()()))

 */