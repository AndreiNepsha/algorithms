package nepsha.competitive.codeforces.kh6p

fun main() {
    val q = readLine()!!.toInt()

    for (query in (1..q)) {
        val (n, a, b) = readLine()!!.split(' ').map(String::toLong)
        val answer = when {
            a <= b/2 -> n*a
            else -> (n/2)*b + (n%2)*a
        }
        println(answer)
    }
}
