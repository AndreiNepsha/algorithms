package nepsha.codewars.choosebestsum

// https://www.codewars.com/kata/55e7280b40e1c4a06d0000aa
fun chooseBestSum(t: Int, k: Int, ls: List<Int>): Int {
    val subsetIndexesSequence = generateSequence(IntArray(k) { it }.reversed()) { indexes ->
        val nextIndexes = indexes.toMutableList()

        var i = 0
        while (i < k && indexes[i] >= ls.size - i - 1) i++

        if (i == k) return@generateSequence null

        var newValue = indexes[i] + 1
        while (i >= 0) nextIndexes[i--] = newValue++

        nextIndexes
    }

    return if (k > ls.size) -1 else subsetIndexesSequence
        .map { subsetIndexes -> ls.filterIndexed { index, _ -> index in subsetIndexes }.sum() }
        .filter { it <= t }
        .max() ?: -1
}


