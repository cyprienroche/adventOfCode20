package day

import Problem
import java.io.PrintStream
import java.util.*

class Day7(private val scanner: Scanner, private val printStream: PrintStream) : Problem {

    private val bagToBagsInsideIt = mutableMapOf<Bag, MutableMap<Bag, Int>>()
    private val bagToBagsOutsideIt = mutableMapOf<Bag, MutableMap<Bag, Int>>()

    val bagsInside = bagToBagsInsideIt as Map<Bag, Map<Bag, Int>>
    val bagsOutside = bagToBagsOutsideIt as Map<Bag, Map<Bag, Int>>

    override fun solvePart1(): Unit {
        while (scanner.hasNext()) addBagFromString(scanner.nextLine())

        printStream.println(countNumberOfBagsOutside(Bag("shiny", "gold")))
    }

    override fun solvePart2(): Unit {
        while (scanner.hasNext()) addBagFromString(scanner.nextLine())

        printStream.println(countNumberOfBagsInside(Bag("shiny", "gold")))
    }

    private fun countNumberOfBagsOutside(bag: Bag): Int {
        val visited = mutableSetOf<Bag>()

        val queue = mutableSetOf(bag)
        var count = 0
        while (queue.isNotEmpty()) {
            val b = queue.first()

            queue.remove(b)
            visited.add(b)
            count++

            val bags = bagsOutside[b]?.keys ?: continue
            queue.addAll(bags.filter { !visited.contains(it) })
        }
        return count - 1
    }

    private fun countNumberOfBagsInside(bag: Bag): Int {
        var count = 0
        bagsInside.map { println("${it.key} - ${it.value}") }

        var queue: Queue<Pair<Bag, Int>> = LinkedList()
        queue.add(bag to 1)

        while (queue.isNotEmpty()) {
            println(count)
            println(queue)
            println()

            val bc = queue.poll()
            count += bc.second

            val bagsAndCount = bagsInside[bc.first] ?: continue
            bagsAndCount.forEach { queue.add(it.key to it.value * bc.second) }
        }
        return count - 1
    }

    fun addBagFromString(line: String): Unit {
        val bagMatch = Regex(bagPattern).find(line) ?: error("rule does not follow expected format")
        val (pattern, colour) = bagMatch.destructured
        val bag = Bag(pattern, colour)
        bagToBagsInsideIt.putIfAbsent(bag, mutableMapOf())

        if (Regex(containsNoBagsPattern).containsMatchIn(line)) return
        addBagsToInsideAndOutsideMaps(line, bag)
    }

    private fun addBagsToInsideAndOutsideMaps(line: String, bag: Bag) {
        val containedBagsMatch = Regex(containedBagPattern).findAll(line)
        val iterator = containedBagsMatch.iterator()

        while (iterator.hasNext()) {
            val (n, p, c) = iterator.next().destructured
            val b = Bag(p, c)
            bagToBagsInsideIt[bag]?.put(b, n.toInt())
            bagToBagsOutsideIt.putIfAbsent(b, mutableMapOf())
            bagToBagsOutsideIt[b]?.put(bag, n.toInt())
        }
    }
}

typealias Pattern = String
typealias Colour = String

const val bagPattern = """(\w+) (\w+) bags?"""
const val containsNoBagsPattern = """no other bags."""
const val containedBagPattern = """(\d+) $bagPattern"""

data class Bag(val pattern: Pattern, val colour: Colour)