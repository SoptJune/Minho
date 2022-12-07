package math

fun main() {
    val N = readln().toInt()
    val divisorArray = readln().split(' ').map { it.toInt() }.sortedDescending()
    print(
        if (divisorArray.size == 1) divisorArray.first() * divisorArray.first() else {
            divisorArray.first() * divisorArray.last()
        })
}