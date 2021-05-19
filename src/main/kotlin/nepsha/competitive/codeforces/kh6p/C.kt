package nepsha.competitive.codeforces.kh6p

fun main() {
    readLine() // skip
    val line = readLine()!!
    var streak = 0
    var answer = 0
    for (c in line.toCharArray()) {
        streak = if (c == 'x') streak+1 else 0
        if (streak >= 3) answer++
    }
    print(answer)
}

