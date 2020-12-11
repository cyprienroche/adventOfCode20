package day6

import getScanner
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.PrintStream
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNull

class Day6Test {

    private val outContent = ByteArrayOutputStream()


    @Test
    fun `can load example input and print correct output for part 1`() {
        val scanner = getScanner(6, "test")
        val printStream = PrintStream(outContent)
        Day6(scanner, printStream).solvePart1()
        val output = outContent.toString().trimMargin().toInt()
        assertEquals(11, output)
    }

    @Test
    fun `can load example input and print correct output for part 2`() {
        val scanner = getScanner(6, "test")
        val printStream = PrintStream(outContent)
        Day6(scanner, printStream).solvePart2()
        val output = outContent.toString().trimMargin().toInt()
        assertEquals(6, output)
    }


}