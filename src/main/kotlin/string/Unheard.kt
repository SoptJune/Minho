package string
/*
    백준 1764번 (듣보잡)
    집합
    첫째 줄에 듣도 못한 사람의 수 N, 보도 못한 사람의 수 M이 주어진다.
    이어서 둘째 줄부터 N개의 줄에 걸쳐 듣도 못한 사람의 이름과,
    N+2째 줄부터 보도 못한 사람의 이름이 순서대로 주어진다.
    이름은 띄어쓰기 없이 알파벳 소문자로만 이루어지며,
    그 길이는 20 이하이다. N, M은 500,000 이하의 자연수이다.
    그냥 리스트 두 개에서 교집합을 구하라는 것
 */

fun main() {
    val (N, M) = readln().split(' ').map { it.toInt() }
    val arrayN = ArrayList<String>()
    val arrayM = ArrayList<String>()
    repeat(N) {
        arrayN.add(readln())
    }
    repeat(M) {
        arrayM.add(readln())
    }
    val directoryN = arrayN.groupBy { it }
    val directoryM = arrayM.groupBy { it }
    val newArray = if (N > M) directoryM.filter { findValue ->
        findValue.value == directoryN[findValue.key]
    }.toSortedMap() else directoryN.filter { findValue ->
        findValue.value == directoryM[findValue.key]
    }.toSortedMap()
    println(newArray.size)
    println(newArray.keys.joinToString("\n"))
}