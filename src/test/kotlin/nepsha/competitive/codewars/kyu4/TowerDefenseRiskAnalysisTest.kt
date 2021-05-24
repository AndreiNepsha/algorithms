package nepsha.competitive.codewars.kyu4

import org.junit.Test
import kotlin.test.assertEquals

class TowerDefenseRiskAnalysisTest {
    private fun runTest(
        grid: Array<String>,
        turrets: Map<Char, Pair<Int, Int>>,
        aliens: IntArray,
        exp: Int,
        survivors: Array<Pair<Int, Int>>
    ) {
        val user = TD.towerDefense(grid, turrets, aliens)
        assertEquals(
            exp,
            user,
            "The aliens that successfully breached our defenses:\n${
                survivors.map { "Alien ${it.first} with ${it.second} health" }.joinToString("\n")
            }\n"
        )
    }

    @Test
    fun `Example Test 1`() = runTest(
        arrayOf(
            "0111111",
            "  A  B1",
            " 111111",
            " 1     ",
            " 1C1111",
            " 111 D1",
            "      1"
        ),
        mapOf(
            'A' to Pair(3, 2),
            'B' to Pair(1, 4),
            'C' to Pair(2, 2),
            'D' to Pair(1, 3)
        ),
        intArrayOf(30, 14, 27, 21, 13, 0, 15, 17, 0, 18, 26),
        10,// expected solution
        arrayOf(7 to 2, 8 to 8)// surviving aliens
    )

    @Test
    fun `Example Test 2`() = runTest(
        arrayOf(
            "011  1111",
            " A1  1BC1",
            " 11  1 11",
            " 1D  1 1E",
            " 111 1F11",
            "  G1 1  1",
            " 111 1 11",
            " 1H  1 1I",
            " 11111 11"
        ),
        mapOf(
            'A' to Pair(1, 4),
            'B' to Pair(2, 2),
            'C' to Pair(1, 3),
            'D' to Pair(1, 3),
            'E' to Pair(1, 2),
            'F' to Pair(3, 3),
            'G' to Pair(1, 2),
            'H' to Pair(2, 3),
            'I' to Pair(2, 3)
        ),
        intArrayOf(36, 33, 46, 35, 44, 27, 25, 48, 39, 0, 39, 36, 55, 22, 26),
        3,
        arrayOf(11 to 3)
    )

    @Test
    fun `Example Test 3`() = runTest(
        arrayOf(
            "01111111",
            " A    B1",
            "11111111",
            "1 C D E ",
            "1 111111",
            "1 1F  G1",
            "1H1 1111",
            "111 1   "
        ),
        mapOf(
            'A' to Pair(2, 2),
            'B' to Pair(1, 3),
            'C' to Pair(3, 3),
            'D' to Pair(1, 2),
            'E' to Pair(1, 4),
            'F' to Pair(2, 3),
            'G' to Pair(1, 3),
            'H' to Pair(2, 2)
        ),
        intArrayOf(37, 29, 16, 13, 42, 39, 8, 14, 35, 26, 59, 0, 44, 19, 17, 35, 49, 31, 0, 43),
        12,
        arrayOf(15 to 12)
    )

    @Test
    fun `Example Test 4`() = runTest(
        arrayOf(
            "1111111111",
            "1A      B1",
            "111C111111",
            "  1 1D    ",
            "011E111111",
            "        F1",
            "G1111111 1",
            "11  H  111",
            "1 I111  J ",
            "1111K11111"
        ),
        mapOf(
            'A' to Pair(1, 2),
            'B' to Pair(1, 4),
            'C' to Pair(1, 3),
            'D' to Pair(2, 2),
            'E' to Pair(3, 3),
            'F' to Pair(1, 3),
            'G' to Pair(2, 2),
            'H' to Pair(1, 3),
            'I' to Pair(2, 2),
            'J' to Pair(1, 3),
            'K' to Pair(1, 2)
        ),
        intArrayOf(
            36,
            27,
            19,
            35,
            0,
            60,
            0,
            80,
            35,
            18,
            49,
            53,
            0,
            47,
            0,
            62,
            0,
            34,
            26,
            53,
            35,
            0,
            31,
            44,
            64,
            21,
            31,
            0,
            59,
            30,
            53,
            31,
            42,
            39
        ),
        21,
        arrayOf(18 to 8, 21 to 3, 23 to 9, 25 to 1)
    )

    @Test
    fun `Example Test 5`() = runTest(
        arrayOf(
            "11111111111",
            "1A  B   C 0",
            "111 111111 ",
            " D1 1E   1 ",
            "111 1 1111 ",
            "1F  1 1    ",
            "1 111 1G111",
            "1 1 H 1 1I1",
            "1J1 111 1 1",
            "111 1K  1 1",
            "    11111 1"
        ),
        mapOf(
            'A' to Pair(1, 3),
            'B' to Pair(1, 2),
            'C' to Pair(2, 2),
            'D' to Pair(1, 4),
            'E' to Pair(4, 2),
            'F' to Pair(2, 2),
            'G' to Pair(3, 2),
            'H' to Pair(1, 2),
            'I' to Pair(1, 2),
            'J' to Pair(2, 3),
            'K' to Pair(1, 3)
        ),
        intArrayOf(
            50,
            40,
            25,
            54,
            26,
            0,
            64,
            21,
            36,
            35,
            0,
            24,
            38,
            0,
            69,
            32,
            56,
            24,
            33,
            63,
            19,
            56,
            39,
            43,
            28,
            11,
            42,
            32,
            51,
            43,
            27,
            0,
            42,
            0,
            0,
            65,
            24,
            28,
            38,
            29,
            0,
            45,
            34,
            27,
            44
        ),
        30,
        arrayOf(16 to 5, 18 to 9, 20 to 4, 25 to 7, 26 to 4, 37 to 1)
    )
}