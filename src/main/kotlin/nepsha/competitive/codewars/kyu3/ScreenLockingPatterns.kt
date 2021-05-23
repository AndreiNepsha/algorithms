package nepsha.competitive.codewars.kyu3

class Graph {
    private data class Vertex(val name: String) {
        val neighbors = mutableSetOf<Vertex>()
        val transitiveNeighbours = mutableSetOf<Pair<Vertex, Vertex>>()
    }

    private val vertices = mutableMapOf<String, Vertex>()

    private operator fun get(name: String) = vertices[name] ?: throw IllegalArgumentException()

    fun addVertex(name: String) {
        vertices[name] = Vertex(name)
    }

    private fun connect(first: Vertex, second: Vertex) {
        first.neighbors.add(second)
        second.neighbors.add(first)
    }

    fun connect(first: String, second: String) = connect(this[first], this[second])

    fun neighbors(name: String) = vertices[name]?.neighbors?.map { it.name } ?: listOf()

    private fun transConnect(first: Vertex, via: Vertex, second: Vertex) {
        first.transitiveNeighbours.add(via to second)
        second.transitiveNeighbours.add(via to first)
    }

    fun transConnect(first: String, via: String, second: String) =
        transConnect(this[first], this[via], this[second])

    fun transNeighbors(name: String) = vertices[name]?.transitiveNeighbours
        ?.map { it.first.name to it.second.name } ?: listOf()
}

val vertices = listOf("A", "B", "C", "D", "E", "F", "G", "H", "I")

val connections = listOf(
    "A" to "B", "A" to "E", "A" to "D", "A" to "F", "A" to "H",
    "B" to "C", "B" to "D", "B" to "E", "B" to "F", "B" to "G", "B" to "I",
    "C" to "D", "C" to "E", "C" to "F", "C" to "H",
    "D" to "E", "D" to "H", "D" to "G", "D" to "I",
    "E" to "F", "E" to "G", "E" to "H", "E" to "I",
    "F" to "G", "F" to "H", "F" to "I",
    "G" to "H",
    "H" to "I"
)

val transConnections = listOf(
    "A" to ("B" to "C"), "A" to ("D" to "G"), "A" to ("E" to "I"),
    "B" to ("E" to "H"),
    "C" to ("E" to "G"), "C" to ("F" to "I"),
    "D" to ("E" to "F"),
    "G" to ("H" to "I")
)

class PatternCounter {
    private val g = Graph()

    init {
        for (v in vertices) g.addVertex(v)
        for (c in connections) g.connect(c.first, c.second)
        for (c in transConnections) g.transConnect(c.first, c.second.first, c.second.second)
    }

    fun countPatternsFrom(firstPoint: String, length: Int): Int {
        return if (length > 9 || length == 0) 0
        else countPatternsFrom(firstPoint, length, setOf(firstPoint))
    }

    private fun countPatternsFrom(firstPoint: String, length: Int, visited: Set<String>): Int {
        if (length == 1) return 1

        var paths = 0

        val possibleNeighbours = (g.neighbors(firstPoint).filter { it !in visited }) +
                (g.transNeighbors(firstPoint).filter { it.first in visited && it.second !in visited }
                    .map { it.second })

        for (n in possibleNeighbours) {
            paths += countPatternsFrom(n, length - 1, visited + n)
        }

        return paths
    }
}

fun countPatternsFrom(firstPoint: String, length: Int): Int =
    PatternCounter().countPatternsFrom(firstPoint, length)

