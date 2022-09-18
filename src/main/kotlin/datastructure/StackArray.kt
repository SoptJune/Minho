package datastructure

import java.io.BufferedWriter
import java.io.OutputStreamWriter

val n = readln().toInt()
val arrayStack = ArrayList<Int>()
val arrayASC = ArrayList<Int>()
val str = StringBuilder()
fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    repeat(n) {
        arrayStack.add(readln().toInt())
    }
    repeat(n) { index ->

        str.append("+\n")
        arrayASC.add(index + 1)
        if (arrayStack.first() == index + 1) {
            upStreamCheck()
        }
    }
    if (arrayASC.isNotEmpty()) {
        println("NO")
    }else{
        bw.write(str.toString())
    }
    bw.close()
}

fun upStreamCheck() {
    for (i in arrayASC.lastIndex downTo 0) {
        if (arrayASC[i] == arrayStack.first()) {
            arrayStack.removeFirstOrNull()
            str.append("-\n")
            arrayASC.removeAt(i)
        } else {
            break
        }
    }
}