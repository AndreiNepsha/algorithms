package nepsha.codewars.choosebestsum

import nepsha.codewars.spinwords.spinWords
import org.junit.Test
import java.util.*
import kotlin.collections.ArrayList
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