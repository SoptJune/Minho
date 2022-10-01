package string

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.Stack

fun main() {
    var str = readln()
    val bomb = readln()
    val stack = Stack<Char>()
    val answer = StringBuilder()
    val bw = BufferedWriter(OutputStreamWriter(System.out))

    str.forEach {
        stack.push(it)
        if (stack.size >= bomb.length && stack.peek() == bomb.last()) {
            var bool = true
            bomb.forEachIndexed { index, c ->
                if (stack[stack.size - bomb.length + index] != c) {
                    bool = false
                    return@forEachIndexed
                }
            }
            if (bool) {
                repeat(bomb.length) {
                    stack.pop()
                }
            }
        }
    }
    if (stack.isNotEmpty()) bw.write(stack.joinToString("")) else bw.write("FRULA")
    bw.close()
}