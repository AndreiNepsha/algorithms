package nepsha.competitive.codewars.rangeextraction

fun rangeExtraction(arr: IntArray): String = arr
    .fold(listOf<Pair<Int, Int>>()) { ranges, i ->
        if (ranges.isEmpty() || i - ranges.last().second != 1) ranges + Pair(i, i)
        else ranges.subList(0, ranges.lastIndex) + Pair(ranges.last().first, i)
    }
    .joinToString(",") {
        when (it.second - it.first) {
            0 -> it.first.toString()
            1 -> "${it.first},${it.second}"
            else -> "${it.first}-${it.second}"
        }
    }