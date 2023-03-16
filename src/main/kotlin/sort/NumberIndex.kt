package sort

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val T = readln().toInt()
    val stringBuilder = StringBuilder()
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    repeat(T) {
        val N = readln().toInt()
        val array = ArrayList<String>()
        repeat(N) {
            array.add(readln())
        }
        array.sort()

        var flag = false
        for (i in 1 until array.size) {
            if (array[i - 1].length < array[i].length) {
                if (array[i - 1] == array[i].substring(0, array[i - 1].length)) {
                    flag = true
                    break
                }
            }
        }
        if (flag) {
            stringBuilder.append("NO\n")
        } else {
            stringBuilder.append("YES\n")
        }
    }
    bw.write(stringBuilder.toString())
    bw.close()
}