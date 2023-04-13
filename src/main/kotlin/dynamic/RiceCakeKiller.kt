package dynamic

import java.io.BufferedWriter
import java.io.OutputStreamWriter
import kotlin.system.exitProcess

val Num = readln().toInt()
val myArray = Array(Num) {
    readln().split(" ").map { it.toInt() }.filterIndexed { index, i -> index != 0 }
}
private val myTour = Array(Num) {
    BooleanArray(10)
}
val bw = BufferedWriter(OutputStreamWriter(System.out))
fun main() {

    if (myArray.size == 1) {
        bw.write(myArray[0][0].toString())
        return
    }
    search("", 0, -1)
    bw.write((-1).toString())
    bw.close()
}

fun search(travelMap: String, depth: Int, select:Int) {
    if (depth == Num) {
        bw.write(travelMap)
        bw.close()
        exitProcess(0)
    }
    myArray[depth].forEach {
        if (!myTour[depth][it] && select != it) {
            myTour[depth][it] = true
            search(travelMap + it + "\n", depth + 1, it)
        }
    }
}