package string

import kotlin.math.ceil

fun main() {
    while (true) {
        val str = readln()
        if (str == "0")
            return
        if(str.slice(IntRange(ceil(((str.length.toDouble() / 2))).toInt(), str.length - 1)).reversed() == str.slice(IntRange(0, (str.length / 2) - 1))){
            println("yes")
        }else{
            println("no")
        }
    }
}