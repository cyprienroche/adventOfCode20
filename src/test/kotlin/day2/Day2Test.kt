package day2

import getScanner
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals

class Day2Test {

    private val outContent = ByteArrayOutputStream()

    @Test
    fun canRecogniseValidPassword1() {
        assertEquals(1, isValidPassword1(1,4, 'a', "abc"))
        assertEquals(1, isValidPassword1(1,4, 'a', "aaaa"))
        assertEquals(1, isValidPassword1(1,3, 'z', "pazzword"))
    }

    @Test
    fun canRecogniseInvalidPassword1() {
        assertEquals(0, isValidPassword1(1,4, 'a', "aaaaa"))
        assertEquals(0, isValidPassword1(1,3, 'z', "pazzzzword"))
    }

    @Test
    fun `can load example input and print correct output for part 1`() {
        val scanner = getScanner(2, "test")
        val printStream = PrintStream(outContent)
        Day2(scanner, printStream).solvePart1()
        val output = outContent.toString().trimMargin().toInt()
        assertEquals(2, output)
    }

    @Test
    fun canRecogniseValidPassword2() {
        assertEquals(1, isValidPassword2(1,4, 'a', "abcd"))
        assertEquals(1, isValidPassword2(1,4, 'a', "baaa"))
        assertEquals(1, isValidPassword2(1,3, 'z', "pazzword"))
    }

    @Test
    fun canRecogniseInvalidPassword2() {
        assertEquals(0, isValidPassword2(1,4, 'a', "abca"))
        assertEquals(0, isValidPassword2(1,4, 'a', "bbbb"))
        assertEquals(0, isValidPassword2(1,2, 'z', "pazzzzword"))
    }


    @Test
    fun `can load example input and print correct output for part 2`() {
        val scanner = getScanner(2, "test")
        val printStream = PrintStream(outContent)
        Day2(scanner, printStream).solvePart2()
        val output = outContent.toString().trimMargin().toInt()
        assertEquals(1, output)
    }
}