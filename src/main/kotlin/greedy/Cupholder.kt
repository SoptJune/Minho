package greedy

/*
    백준 2810번 (컵 홀더)
    그리디 풀이도 아님
 */
private val N = readln().toInt()
private var S = readln()
fun main() {
    S = S.replace("LL", "L")
    if (S.length + 1 > N) print(N) else print(S.length + 1)
}