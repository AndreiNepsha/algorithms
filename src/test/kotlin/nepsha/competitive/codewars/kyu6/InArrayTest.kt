package nepsha.competitive.codewars.kyu6

import org.junit.Assert.assertArrayEquals
import org.junit.Test

class InArrayTest {
    @Test
    fun testFixed() {
        val a2 = arrayOf("lively", "alive", "harp", "sharp", "armstrong")
        assertArrayEquals(arrayOf<String>("live", "strong"), inArray(arrayOf<String>("xyz", "live", "strong"), a2))
        assertArrayEquals(
            arrayOf<String>("arp", "live", "strong"),
            inArray(arrayOf<String>("live", "strong", "arp"), a2)
        )
        assertArrayEquals(arrayOf<String>(), inArray(arrayOf<String>("tarp", "mice", "bull"), a2))
    }
}