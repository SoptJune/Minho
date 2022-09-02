package datastructure

import java.io.BufferedWriter
import java.io.OutputStreamWriter

data class Balloon(val moveIndex: Int, val index: Int)

/*5
3 2 1 -3 -1  (3 -> 1) index : 0, popIndex : 3
2 1 -3 -1   (-3 -> 4) index : 2, popIndex : 3
2 1 -1  (-1 -> 5) index : 2, 1
2 1 (1 -> 3)
2 (2 -> 2)

*/

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