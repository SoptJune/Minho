package sort

fun main() {
    val N = readln().toInt()
    val array = mutableListOf<String>()
    repeat(N){
        array.add(readln())
    }
    val comparator: Comparator<String> = compareBy<String> { it.length }.thenBy { it -> it.replace("[^0-9]".toRegex(), "").map { it.digitToInt() }.sum() }.thenBy { it }
    println(array.sortedWith(comparator).joinToString("\n"))
}