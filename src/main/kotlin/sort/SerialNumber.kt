package sort

/*
    백준 1431번 (시리얼 넘버)
    단순 정렬
 */
fun main() {
    val N = readln().toInt()
    val array = mutableListOf<String>()
    repeat(N){
        array.add(readln())
    }
    val comparator: Comparator<String> = compareBy<String> { it.length }.thenBy { it -> it.replace("[^0-9]".toRegex(), "").map { it.digitToInt() }.sum() }.thenBy { it }
    println(array.sortedWith(comparator).joinToString("\n"))
}