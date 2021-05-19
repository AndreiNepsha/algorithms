package nepsha.competitive.codeforces.kh6

fun main() {
    val t = readLine()!!.toInt()

    for (i in (1..t)) {
        var (x, y) = readLine()!!.split(' ').map(String::toLong)
        var ops = 0L

        var m =  (2..(Long.MAX_VALUE/x).toString().length).fold(1L, {z, _ -> z * 10L}) * x
        while (true) {
            ops += y/m
            y %= m
            m /= 10
            if (m < x) {
                ops += y
                break
            }
        }
        println(ops)
    }
}
