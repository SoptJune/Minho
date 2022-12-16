package string

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.Stack
/*
    백준 9935번 (문자열 폭발)
    특정 폭발 문자 정해서 문자열에 적혀있으면 폭발하여 사라짐
    남은 문자열에서도 폭발시킴
 */

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