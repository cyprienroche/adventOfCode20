package day

import Problem
import java.io.PrintStream
import java.util.Scanner

class Day2(private val scanner: Scanner, private val printStream: PrintStream) : Problem {

    private val pattern = """(\d+)-(\d+) (\w): (\w+)"""

    override fun solvePart1() = solve(::isValidPassword1)

    override fun solvePart2() = solve(::isValidPassword2)

    private fun solve(f: (Int, Int, Char, String) -> Int) {
        var count = 0
        while (scanner.hasNext()) {
            val input = scanner.nextLine()

            val match = Regex(pattern).find(input)!!
            val (i, j, char, password) = match.destructured
            count += f(i.toInt(), j.toInt(), char[0], password)
        }
        printStream.println(count)
        return
    }
}

fun isValidPassword1(min: Int, max: Int, char: Char, password: String): Int =
    if (password.count { it == char } in min..max) 1 else 0

fun isValidPassword2(pos1: Int, pos2: Int, char: Char, password: String): Int =
    if ((pos1 - 1 in password.indices && password[pos1 - 1] == char).xor(
            pos2 - 1 in password.indices && password[pos2 - 1] == char
        )
    )
        1 else 0
