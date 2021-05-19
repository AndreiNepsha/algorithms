package nepsha.competitive.codeforces.kh6p

import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val lenToStrings = TreeMap<Int, MutableList<String>>()

    for (i in (1..n)) {
        val line = readLine()!!
        if (lenToStrings[line.length] != null) {
            lenToStrings[line.length]!!.add(line)
        } else {
            lenToStrings[line.length] = mutableListOf(line)
        }
    }

    val result = mutableListOf<String>()
    var hasResult = true

    for ((_, strings) in lenToStrings) {
        val s = strings[0]
        if (strings.any { it != s } ||
            result.isNotEmpty() &&
            !s.contains(result.last())
        ) hasResult = false

        if (hasResult) result.addAll(strings)
        else break
    }

    if (hasResult) {
        println("YES")
        for (s in result) println(s)
    } else {
        println("NO")
    }
}