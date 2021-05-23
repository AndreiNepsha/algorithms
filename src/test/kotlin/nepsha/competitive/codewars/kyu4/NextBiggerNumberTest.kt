package nepsha.competitive.codewars.kyu4

import nepsha.competitive.codewars.kyu4.rangeExtraction
import org.junit.Test
import kotlin.test.assertEquals

class NextBiggerNumberTest {
    @Test
    fun basicTests() {
        assertEquals(21, nextBiggerNumber(12))
        assertEquals(531, nextBiggerNumber(513))
        assertEquals(2071, nextBiggerNumber(2017))
        assertEquals(441, nextBiggerNumber(414))
        assertEquals(414, nextBiggerNumber(144))
        assertEquals(1234567908, nextBiggerNumber(1234567890))
        assertEquals(-1, nextBiggerNumber(987654321))
    }
}