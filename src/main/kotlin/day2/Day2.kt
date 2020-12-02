package day2

import Problem
import java.io.PrintStream
import java.util.Scanner

class Day2(private val scanner: Scanner, private val printStream: PrintStream) : Problem {

    private val pattern = """(\d+)-(\d+) (\w): (\w+)"""

    override fun solvePart1() {
        var count = 0
        while (scanner.hasNext()) {
            val input = scanner.nextLine()
            println(input)

            val match = Regex(pattern).find(input)!!
            val (min, max, char, password) = match.destructured
            val range = min.toInt().rangeTo(max.toInt())
            count += isValidPassword(range, char[0], password)
        }
        printStream.println(count)
        return
    }

    override fun solvePart2() {
        return
    }
}

fun isValidPassword(range: IntRange, char: Char, password: String): Int =
    if (password.count { it == char } in range) 1 else 0