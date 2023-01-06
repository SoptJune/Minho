package sort

fun main() {
    println(solution(intArrayOf(1)))
    println(solution(intArrayOf(0, 1, 4)))
    println(solution(intArrayOf(3, 0, 6, 1, 5)))
    println(solution(intArrayOf(12, 11, 10, 9, 8, 1)))
}
//1, 8, 9, 10, 11, 12
private fun solution(citations: IntArray): Int {
    citations.sortDescending() //내림차순 정렬
    if(citations.last() > citations.size){ //제일 작은 인용수가 배열의 길이보다 클 때는
        return citations.size //배열 길이 리턴
    }//왜냐하면 쉽게 생각했을 때 나머진 다 엄청 큰 수들이면 어차피 배열의 길이만큼 인용한 수가 최대 값이 되기 때문
    for(i in 1 .. citations.size){
        if(i>citations[i-1]){ // 이외에는 논문의 갯수가 현재 인덱스의 인용 개수보다 커지는 순간에
            return i-1        // 이전까지의 논문 갯수가 최대일거
        }                     // 근데 왜 이외의 나머지 누적 값은 계산 안할까?
    }
    return 0
    /*var array = IntArray(citations.size).apply {
        this[0] = citations.first()
    }
    for (i in 1 until citations.size) {
        array[i] = array[i - 1] + citations[i]
    }
    var idx = citations.size - 1
    //12, 5
    for (i in maxCitation downTo 0) {
        if (idx < 0) {
            break
        }
        if (citations[idx] >= i && ((citations.size - 1) - idx >= i)) {
            if (array[idx] < i) {
                answer = answer.coerceAtLeast(i)
            } else {
                idx--
            }
        } else if ((citations.size - 1) - idx < i) {
            idx--
        }
    }*/

    /*
    for (i in maxCitation downTo 1) {
        if (citations.filter { it >= i }.size >= i) {
            if (citations.filter { it < i }.sum() <= i) {
                return i
            }
        }
    }*/
}