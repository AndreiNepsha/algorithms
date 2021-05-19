package nepsha.competitive.codeforces.kh6

import java.lang.Integer.max
import java.lang.Integer.min

// todo not working solution
fun main() {
    val t = readLine()!!.toInt()

    for (i in (1..t)) {
        var (n, x, y) = readLine()!!.split(' ').map(String::toInt)

        if (x > y) {
            y += x
            x = y - x
            y -= x
        }

        val firstWay = max(y - 1, n - x)

        var sWay = 0

        val xToS = x - 1
        val xToSToY = xToS + (y - 2)

        val yToE = n - y
        val yToEToX = yToE + (n - x - 1)

        if (xToSToY <= yToE * 2) sWay = max(xToSToY, yToE)
        else if (yToEToX <= xToS * 2) sWay = max(yToEToX, xToS)
        else {
            val min = min(yToE, xToS)
            val max = max(yToE, xToS)
            sWay = if (max != min) {
                if ((y-x)/2 > max)
                    (max-min)*2 + max
                else max + (n-min-1) / 2
            } else max + n / 2
        }
        println(min(firstWay, sWay))
    }
}