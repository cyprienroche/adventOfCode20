package day1

import Problem
import java.io.PrintStream
import java.util.Scanner

class Day1(private val scanner: Scanner, private val printStream: PrintStream): Problem {

    private val input = mutableListOf<Int>()

    private fun load(): Unit {
        while (scanner.hasNext()) {
            input.add(scanner.nextInt())
        }
    }

    override fun solve(): Unit {
        solvePart2()
    }

    fun solvePart1() {
        load()
        val (p, q) = findPairThatSumsToTarget(input, target = 2020)
        printStream.println(p * q)
    }

    fun solvePart2() {
        load()
        val (p, q, r) = findTripleThatSumsToTarget(input, target = 2020)
        printStream.println(p * q * r)
    }
}

fun findPairThatSumsToTarget(input: List<Int>, target: Int): Pair<Int, Int> {
    val set = hashSetOf<Int>()
    input.forEach {
        val complement = target - it
        if (set.contains(complement)) return Pair(complement, it)
        set.add(it)
    }
    return Pair(-1,-1)
}

fun findTripleThatSumsToTarget(input: List<Int>, target: Int): Triple<Int, Int, Int> {
    input.forEachIndexed { index, it ->
        val (p, q) = findPairThatSumsToTarget(input.drop(index + 1), target - it)
        if (p != -1) return Triple(it, p, q)
    }
    return Triple(-1,-1, -1)
}