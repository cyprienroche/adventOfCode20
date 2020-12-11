package day

import Problem
import java.io.PrintStream
import java.util.*

class Day6(private val scanner: Scanner, private val printStream: PrintStream) : Problem {

    private fun nextPassenger(line: String): Passenger = Passenger(line.trimIndent().toSet())

    private fun nextGroup(): Group {
        var line = scanner.nextLine()
        var numberOfPassengers = 0
        val map = mutableMapOf<Char, Int>()

        while (line.isNotBlank()) {
            val passenger = nextPassenger(line)
            passenger.yesQuestions.forEach {
                map.putIfAbsent(it, 0)
                map.computeIfPresent(it) { _, v -> v + 1 }
            }
            numberOfPassengers++

            if (!scanner.hasNext()) break
            line = scanner.nextLine()
        }

        return Group(map, numberOfPassengers)
    }

    override fun solvePart1(): Unit {
        val groups = mutableListOf<Group>()
        while (scanner.hasNext()) groups.add(nextGroup())
        printStream.println(groups.fold(0) { n, group -> n + group.yesQuestions.size })
    }

    override fun solvePart2(): Unit {
        val groups = mutableListOf<Group>()
        while (scanner.hasNext()) groups.add(nextGroup())
        printStream.println(groups.fold(0) { n, group ->
            n + group.yesQuestions.filter { (_, c) -> c == group.numberOfPassenger }.size
        })
    }
}

data class Passenger(val yesQuestions: Set<Char>)

data class Group(val yesQuestions: Map<Char, Int>, val numberOfPassenger: Int)