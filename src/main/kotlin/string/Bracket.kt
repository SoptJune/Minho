package string

fun main() {
    repeat(readln().toInt()) {
        println(validityCheckBracket(readln()))
    }
}

fun validityCheckBracket(testCase: String): String {
    val bracketStack = ArrayList<Char>()
    testCase.forEach {
        when (it) {
            '(' -> bracketStack.add(it)
            ')' -> {
                if (bracketStack.isEmpty()) return "NO"
                bracketStack.removeLastOrNull()
            }
        }
    }
    if (bracketStack.isEmpty())
        return "YES"
    return "NO"
}