package day1

import getScanner
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals

class Day1Test {

    private val outContent = ByteArrayOutputStream()

    @Test
    fun `can find correct pair that sums to target`() {
        val pair = findPairThatSumsToTarget(listOf(1, 2, 3, 4, 5), 9)
        assertEquals(Pair(4, 5), pair)
    }

    @Test
    fun `can find correct triple that sums to target`() {
        val triple = findTripleThatSumsToTarget(listOf(1, 2, 3, 4, 5), 12)
        assertEquals(Triple(3, 4, 5), triple)
    }

    @Test
    fun `can load example input and print correct output for pair`() {
        val scanner = getScanner(1, "test")
        val printStream = PrintStream(outContent)
        Day1(scanner, printStream).solvePart1()
        val output = outContent.toString().trimMargin().toInt()
        assertEquals(514579, output)
    }

    @Test
    fun `can load example input and print correct output for triple`() {
        val scanner = getScanner(1, "test")
        val printStream = PrintStream(outContent)
        Day1(scanner, printStream).solvePart2()
        val output = outContent.toString().trimMargin().toInt()
        assertEquals(241861950, output)
    }
}