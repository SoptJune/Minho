package sort

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readln().toInt()
    var array = mutableListOf<String>()
    for (i in 0 until N) {
        array.add(readln())
    }
    array = array.distinct().toMutableList()
    val comparator: Comparator<String> = compareBy<String> { it.length }.thenBy { it }
    println(array.sortedWith(comparator).joinToString("\n"))

}

