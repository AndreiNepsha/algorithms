package nepsha.codewars.stripcomments

fun solution(input: String, markers: CharArray): String = input.split('\n')
    .joinToString("\n") {
        val firstMarkerIndex = it.indexOfFirst { marker -> marker in markers }
        if (firstMarkerIndex == -1) it
        else it.substring(0, firstMarkerIndex).trim()
    }
