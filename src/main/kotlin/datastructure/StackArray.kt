package datastructure

import java.io.BufferedWriter
import java.io.OutputStreamWriter

/*
    뭔지 모르겠음 문제를 못 찾음
 */

private val n = readln().toInt()
private val arrayStack = ArrayList<Int>()
private val arrayASC = ArrayList<Int>()
private val str = StringBuilder()
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

private fun upStreamCheck() {
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