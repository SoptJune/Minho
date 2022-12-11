package implement

fun main() {
    val (H, W, X, Y) = readln().split(" ").map { it.toInt() }
    val array = List(H + X) {
        mutableListOf<Int>()
    }
    repeat(H + X) { index ->
        array[index].addAll(readln().split(" ").map { it.toInt() })
    }
    for (i in X until H + X) {
        for (j in Y until W + Y) {
            if (i < H && j < W) {
                array[i][j] -= array[i - X][j - Y]
            }
        }
    }
    array.filterIndexed { index, ints -> index < H }.map { it.filterIndexed { index, i -> index < W } }
        .forEach { println(it.joinToString(" ")) }
}