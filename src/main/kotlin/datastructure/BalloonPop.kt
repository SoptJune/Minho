package datastructure

import java.io.BufferedWriter
import java.io.OutputStreamWriter

/*
    백준 2346번 (풍선 터뜨리기)
    원형 큐 이용
    좌측으로 N이동, 우측으로 N 이동 해주는 과정 해야한다. -로 이동할 때 생각해줘야할 게 많음
    특히 index 0을 지나는 -인 경우에는 잘 생각해줘야한다.
 */


data class Balloon(val moveIndex: Int, val index: Int)

val array = ArrayList<Balloon>()
fun main() {
    val n = readln().toInt()
    val str = StringBuilder()
    val bw = BufferedWriter(OutputStreamWriter(System.out))
    array.addAll(readln().split(" ").mapIndexed { index, s -> Balloon(s.toInt(), index + 1) })
    var i = 0

    str.append("${array[i].index} ")
    var moveIndex = array[i].moveIndex
    array.removeAt(i)
    repeat(n - 1) {
        val popIndex = getPopIndex(moveIndex, i)
        i = popIndex
        str.append("${array[i].index} ")
        moveIndex = array[i].moveIndex
        array.removeAt(i)
    }
    bw.write(str.toString())
    bw.close()
}

fun getPopIndex(index: Int, currentIndex: Int): Int {
    var tempCurrentIndex = currentIndex
    if (index >= 0) {
        if ((currentIndex + index - 1) == 0) return 0
        return (currentIndex + index - 1) % (array.size)
    } else {
        if ((currentIndex + index) >= 0) return currentIndex + index
        else {
            tempCurrentIndex += index
            while (true) {
                tempCurrentIndex += array.size
                if (tempCurrentIndex >= 0) {
                    return tempCurrentIndex
                }
            }
        }
    }
}

/*5
3 2 1 -3 -1  (3 -> 1) index : 0, popIndex : 3
2 1 -3 -1   (-3 -> 4) index : 2, popIndex : 3
2 1 -1  (-1 -> 5) index : 2, 1
2 1 (1 -> 3)
2 (2 -> 2)

*/
