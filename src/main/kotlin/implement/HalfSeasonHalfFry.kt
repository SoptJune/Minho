package implement

fun main() {
    val (A, B, C, X, Y) = readln().split(" ").map { it.toInt() }
    val answer = if (A + B > C * 2) {
        if (X >= Y) {
            if (C * 2 < A) {
                (C * 2) * X
            } else {
                (C * 2) * Y + A * (X - Y)
            }
        } else {
            if (C * 2 < B) {
                (C * 2) * Y
            } else {
                (C * 2) * X + B * (Y - X)
            }
        }
    } else {
        A * X + B * Y
    }
    println(answer)
}