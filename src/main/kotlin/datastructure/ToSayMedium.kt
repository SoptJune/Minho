package datastructure

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import java.util.*


fun main() {
    val N = readln().toInt()
    val minHeap = PriorityQueue<Int>(Collections.reverseOrder())
    val maxHeap = PriorityQueue<Int>()
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val str = StringBuilder()
    repeat(N) {
        val value = readln().toInt()
        if (minHeap.size == maxHeap.size) {
            minHeap.offer(value)
        } else if (minHeap.size > maxHeap.size) {
            maxHeap.offer(value)
        }
        if (minHeap.peek() > (maxHeap.peek()?:10_001)) {
            val temp1 = minHeap.poll()
            val temp2 = maxHeap.poll()
            minHeap.offer(temp2)
            maxHeap.offer(temp1)
        }
        str.append("${minHeap.peek()}\n")
    }
    bw.write(str.toString())
    bw.close()
}


/*
1
answer = 1

1, 5
answer = 1

1, 2, 5
answer = 2

-99 1 2 5
answer = 1
-99 1 2 5 7
answer = 2
-99 1 2 5 5 7
answer = 5
 */