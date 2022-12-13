package greedy

fun main() {
    println(solution(10, 85, 30))
}
fun solution(X: Int, Y: Int, D: Int): Int {
    return if(((Y-X)/ D.toDouble()) == ((Y-X)/ D).toDouble()){
        (Y-X)/ D
    }else{
        (Y-X)/ D+1
    }
}
