package string


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
    }.toSortedMap()else directoryN.filter { findValue ->
            findValue.value == directoryM[findValue.key]
        }.toSortedMap()
    println(newArray.size)
    println(newArray.keys.joinToString("\n"))
}