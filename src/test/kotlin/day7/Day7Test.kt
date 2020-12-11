package day7

import getScanner
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.PrintStream
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNull

class Day7Test {

    private val outContent = ByteArrayOutputStream()


    @Test
    fun `can load example input and print correct output for part 1`() {
        val scanner = getScanner(7, "test")
        val printStream = PrintStream(outContent)
        Day7(scanner, printStream).solvePart1()
        val output = outContent.toString().trimMargin().toInt()
        assertEquals(4, output)
    }

    @Test
    fun `can load example input and print correct output for part 2`() {
        val scanner = getScanner(7, "test")
        val printStream = PrintStream(outContent)
        Day7(scanner, printStream).solvePart2()
        val output = outContent.toString().trimMargin().toInt()
        assertEquals(6, output)
    }


}