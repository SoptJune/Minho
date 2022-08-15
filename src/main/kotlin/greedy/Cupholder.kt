package greedy


val N = readln().toInt()
var S = readln()
fun main() {
    S = S.replace("LL", "L")
    if (S.length + 1 > N) print(N) else print(S.length + 1)
}