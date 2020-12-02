package day2

import getScanner
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals

class Day2Test {

    private val outContent = ByteArrayOutputStream()

    @Test
    fun canRecogniseValidPassword() {
        assertEquals(1, isValidPassword(1..4, 'a', "abc"))
        assertEquals(1, isValidPassword(1..4, 'a', "aaaa"))
        assertEquals(1, isValidPassword(1..2, 'z', "pazzword"))
    }

    @Test
    fun canRecogniseInvalidPassword() {
        assertEquals(0, isValidPassword(1..4, 'a', "aaaaa"))
        assertEquals(0, isValidPassword(1..2, 'z', "pazzzword"))
    }

    @Test
    fun `can load example input and print correct output for part 1`() {
        val scanner = getScanner(2, "test")
        val printStream = PrintStream(outContent)
        Day2(scanner, printStream).solvePart1()
        val output = outContent.toString().trimMargin().toInt()
        assertEquals(2, output)
    }
}