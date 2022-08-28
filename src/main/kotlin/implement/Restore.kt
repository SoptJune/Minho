package implement

import java.io.BufferedWriter
import java.io.OutputStreamWriter


val array = ArrayList<String>()

fun main() {
    repeat(readln().toInt()) {
        array.add(readln())
    }
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    var i = array.size - 1
    while (i >= 0) {
        val (command, optional, currentTime) = array[i].split(" ")
        if (command == "undo") {
            array.removeAt(i--)
            val untilTime = (currentTime.toInt() - optional.toInt())
            if (i >= 0) {
                while (true) {
                    if (i < 0) {
                        break
                    }
                    val (subCommand, subOptional, subCurrentTime) = array[i].split(" ")
                    val subTime = subCurrentTime.toInt()
                    if (untilTime <= subTime) {
                        array.removeAt(i--)
                    } else {
                        break
                    }
                }
            }
        } else {
            i--
        }
    }
    val str = StringBuilder()
    array.forEach {
        str.append(it[5])
    }
    bw.write(str.toString())
    bw.close()
}