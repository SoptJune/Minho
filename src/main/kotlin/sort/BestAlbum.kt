package sort
/*
    프로그래머스 베스트 앨범
    정렬 풀이
    Comparator 가 중요했음
 */

fun main() {
    solution(arrayOf("classic", "pop", "classic", "classic", "pop"), intArrayOf(500, 600, 150, 800, 2500))
}

fun solution(genres: Array<String>, plays: IntArray): IntArray {
    val pairAlbum = ArrayList<Triple<String, Int, Int>>()
    for (i in genres.indices) {
        pairAlbum.add(Triple(genres[i], plays[i], i))
    }
    val newGroup = pairAlbum.groupBy { it.first }.map {//장르 기준으로 그룹화, 재생수 accumulate 구하는 코드, 마지막 정렬까지
        it.key to it.value.sumOf { pair -> pair.second }
    }.sortedByDescending { it.second }.map { it.first }

    pairAlbum.sortedWith(
        compareBy<Triple<String, Int, Int>> { it.first }
            .thenByDescending { it.second }.thenBy { it.third }).toList()

    var answer = mutableListOf<Int>()
    newGroup.forEach { genres ->
        answer.addAll(pairAlbum.filter { it.first == genres }.map { it.third }.take(2))
    }
    println(answer)
    return answer.toIntArray()
}