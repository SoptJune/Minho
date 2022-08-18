package greedy


fun main() {
    val N = readln().toInt()
    val array = readLine()?.split(' ')?.map { it.toInt() }?.sortedDescending()
    var day = 2
    var sum = 0
    array?.forEach {
        if (sum < it + day) {
            sum = it + day
        }
        day++
    }
    println(sum)
}