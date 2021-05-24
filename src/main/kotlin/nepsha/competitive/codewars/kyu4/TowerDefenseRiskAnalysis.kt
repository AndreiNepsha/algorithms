package nepsha.competitive.codewars.kyu4

import java.util.*
import kotlin.math.abs

class AlienOnRoad(
    val alien: Alien,
    var roadPartIndex: Int
)

class GameField(
    turrets: List<Turret>,
    roadParts: List<RoadPart>,
    aliens: IntArray
) {
    private val turrets: List<Turret>
    private var road: List<RoadPart>
    private val aliensPool: Queue<Int>

    init {
        this.turrets = buildTurrets(turrets)
        this.road = buildRoad(roadParts)
        this.aliensPool = createAliensPool(aliens)
    }

    private val aliensOnRoad: MutableList<AlienOnRoad> = LinkedList()

    private var totalDamage = 0
    private var turn = 0

    private var gameOver = false

    private var aliensPolled = 0

    private fun buildTurrets(turrets: List<Turret>) = turrets.sortedWith(compareBy { it.type })

    private fun createAliensPool(aliens: IntArray) = LinkedList<Int>().apply { addAll(aliens.toList()) }

    private fun buildRoad(roadParts: List<RoadPart>): LinkedList<RoadPart> {
        val remainingParts = LinkedList(roadParts)
        val entryPoint = roadParts.first { it.isEntryPoint }
        val road = LinkedList<RoadPart>()
        road.add(entryPoint)
        remainingParts.remove(entryPoint)
        for (i in 1..remainingParts.size)
            for (part in remainingParts)
                if (abs(part.x - road.last().x) + abs(part.y - road.last().y) == 1) {
                    road.add(part)
                    remainingParts.remove(part)
                    break
                }
        return road
    }

    fun calculateCoreDamage(): Int {
        while (!gameOver) {
            nextTurn()
            checkGameOver()
        }
        return totalDamage
    }

    private fun nextTurn() {
        turn++
        moveAliens()
        addAlienFromPull()
        attackAliens()
    }

    private fun checkGameOver() {
        if (aliensOnRoad.size == 0 && aliensPool.size == 0) gameOver = true
    }

    private fun attackAliens() {
        turrets.forEach { it.reload() }

        do {
            var attackEnds = true
            for (t in turrets) {
                if (t.hasShots())
                    getTurretTarget(t)?.also { alienOnRoad ->
                        t.shoot(alienOnRoad.alien)
                        if (alienOnRoad.alien.health <= 0) aliensOnRoad.remove(alienOnRoad)
                        attackEnds = false
                    }
            }
        } while (!attackEnds)
    }

    private fun addAlienFromPull() =
        aliensPool.poll()?.takeIf { it != 0 }?.also { polled ->
            aliensOnRoad.add(AlienOnRoad(Alien(aliensPolled++, polled), 0))
        }

    private fun moveAliens() {
        aliensOnRoad.firstOrNull()
            ?.takeIf { it.roadPartIndex == road.lastIndex }
            ?.also {
                totalDamage += it.alien.health
                println("Alien ${it.alien.n} passed with ${it.alien.health} health")
                aliensOnRoad.remove(it)
            }

        aliensOnRoad.forEach { it.roadPartIndex++ }
    }

    private fun getTurretTarget(t: Turret): AlienOnRoad? =
        aliensOnRoad.firstOrNull {
            val rp = road[it.roadPartIndex]
            abs(rp.x - t.x) + abs(rp.y - t.y) <= t.range
        }
}

abstract class GameFieldObject(
    var x: Int,
    var y: Int
)

class Turret(
    x: Int,
    y: Int,
    val range: Int,
    private val shotFrequency: Int,
    val type: Char
) : GameFieldObject(x, y) {
    private var shots = shotFrequency

    fun hasShots(): Boolean = shots > 0

    fun shoot(alien: Alien) {
        if (hasShots()) {
            alien.health--
            shots--
        }
    }

    fun reload() {
        shots = shotFrequency
    }
}

class RoadPart(x: Int, y: Int, val isEntryPoint: Boolean = false) : GameFieldObject(x, y)

class Alien(
    val n: Int,
    var health: Int
)

// https://www.codewars.com/kata/5a57faad880385f3b60000d0/kotlin
object TD {
    fun towerDefense(grid: Array<String>, turrets: Map<Char, Pair<Int, Int>>, aliens: IntArray): Int {
        val roadParts = mutableListOf<RoadPart>()
        val turretsObjects = mutableListOf<Turret>()
        for ((y, r) in grid.withIndex())
            for ((x, c) in r.toCharArray().withIndex()) {
                when (c) {
                    in 'A'..'Z' -> turretsObjects.add(Turret(x, y, turrets[c]!!.first, turrets[c]!!.second, c))
                    in '0'..'1' -> roadParts.add(RoadPart(x, y, c == '0'))
                }
            }

        val gf = GameField(turretsObjects, roadParts, aliens)
        return gf.calculateCoreDamage()
    }
}