package nepsha.competitive.codeforces.kh6p

import java.util.*
import kotlin.math.min

fun main() {
    val n = readLine()!!.toInt()
    val positions = TreeMap<Int, Pair<Int, Int>>()

    var leftShift = 0
    var rightShift = 0
    for (i in (1..n)) {
        val line = readLine()!!
        val (op, id) = line.split(' ').let {
            it[0] to it[1].toInt()
        }

        val position = positions[id]

        when (op) {
            "R" -> {
                rightShift++
                positions[id] =
                    if (position == null)
                        -rightShift+1 to rightShift
                    else position.first to rightShift
            }
            "L" -> {
                leftShift++
                positions[id] = if (position == null)
                    leftShift to -leftShift+1
                else leftShift to position.second
            }
            "?" -> println(min(leftShift - position!!.first, rightShift - position.second))
        }
    }
}
