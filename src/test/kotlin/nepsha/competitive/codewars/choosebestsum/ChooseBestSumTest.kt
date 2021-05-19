package nepsha.competitive.codewars.choosebestsum

import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

class ChooseBestSumTest {
    @Test
    fun BasicTests1() {
        println("****** Basic Tests small numbers******")
        var ts = ArrayList<Int>(listOf<Int>(50, 55, 56, 57, 58))
        var n = chooseBestSum(163, 3, ts)
        assertEquals(163, n.toLong())
        ts = ArrayList<Int>(listOf<Int>(50))
        var m = chooseBestSum(163, 3, ts)
        assertEquals(-1, m)

    }
}