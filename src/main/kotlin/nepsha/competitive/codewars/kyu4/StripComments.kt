package nepsha.competitive.codewars.kyu4

//https://www.codewars.com/kata/51c8e37cee245da6b40000bd
fun solution(input: String, markers: CharArray): String = input.split('\n')
    .joinToString("\n") {
        val firstMarkerIndex = it.indexOfFirst { marker -> marker in markers }
        if (firstMarkerIndex == -1) it
        else it.substring(0, firstMarkerIndex).trim()
    }
