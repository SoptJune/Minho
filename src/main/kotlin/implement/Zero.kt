package implement

import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val data = readLine().toInt()
    val stack = mutableListOf<Int>()
    for (i in 0 until data) {
        (readLine().toInt()).apply {
            if (this == 0) {
                stack.removeAt(stack.size - 1)
            } else {
                stack.add(this)
            }
        }
    }
    println(stack.sum())
}
