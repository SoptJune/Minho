package implement

import kotlin.math.abs

fun main() {
    val array = readln().split(" ").map { it.toInt() }
    var prev = array[0]
    for(i in 1..7){
        if(abs(prev-array[i]) != 1){
            print("mixed")
            return
        }
        prev = array[i]
    }
    if (prev==1) print("descending") else print("ascending")
}