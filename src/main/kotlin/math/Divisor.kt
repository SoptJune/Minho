package math

/*
    백준 1037번 약수(브론즈 1)
 */
fun main() {
    val N = readln().toInt()
    val divisorArray = readln().split(' ').map { it.toInt() }.sortedDescending()
    print(
        if (divisorArray.size == 1) divisorArray.first() * divisorArray.first() else {
            divisorArray.first() * divisorArray.last()
        }
    )
}