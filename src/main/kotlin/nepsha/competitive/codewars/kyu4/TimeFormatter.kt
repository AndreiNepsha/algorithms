package nepsha.competitive.codewars.kyu4

object TimeFormatter {
    fun formatDuration(totalSeconds: Int): String {
        val components = listOf(
            "year" to totalSeconds / (3600 * 24 * 365),
            "day" to (totalSeconds % (3600 * 24 * 365)) / (3600 * 24),
            "hour" to (totalSeconds % (3600 * 24)) / 3600,
            "minute" to (totalSeconds % 3600) / 60,
            "second" to totalSeconds % 60
        )
            .map { (componentName, componentValue) ->
                when (componentValue) {
                    0 -> ""
                    1 -> "1 $componentName"
                    else -> "$componentValue ${componentName}s"
                }
            }
            .filterNot(String::isEmpty)

        return when (components.size) {
            0 -> "now"
            1 -> components[0]
            else -> components.take(components.size-1).joinToString(", ") +
                    " and ${components[components.size-1]}"
        }
    }
}