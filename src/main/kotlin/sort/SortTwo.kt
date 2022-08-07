package sort

import java.io.BufferedWriter
import java.io.OutputStreamWriter

fun main() {
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    val n = readln().toInt()
    val checkList = BooleanArray(2000001)
    for (i in 0 until n) {
        checkList[1000000 + readln().toInt()] = true
    }
    for (i in checkList.indices) {
        if (checkList[i]) bw.write("${i - 1000000}\n")
    }
    bw.close()
}

fun mergeSort(start: Int, end: Int, array: Array<Int>) {
    if (start >= end) {
        return
    }
    mergeSort(start, (start + end) / 2, array)
    mergeSort(((start + end) / 2) + 1, end, array)
    mergeArray(start, (start + end) / 2, end, array)
}

fun mergeArray(start: Int, mid: Int, end: Int, array: Array<Int>) {
    val tempArray = IntArray(array.size)
    var startIndex = start
    var midIndex = mid + 1
    var tempIndex = 0
    while (true) {
        tempArray[tempIndex++] =
            if (array[startIndex] > array[midIndex]) array[midIndex++]
            else array[startIndex++]
        if (startIndex > mid) {
            for (i in midIndex..end) {
                tempArray[tempIndex++] = array[i]
            }
            for (i in start..end) {
                array[i] = tempArray[i]
            }
            return
        } else if (midIndex > end) {
            for (i in startIndex..mid) {
                tempArray[tempIndex++] = array[i]
            }
            for (i in start..end) {
                array[i] = tempArray[i]
            }
            return
        }
    }
}

