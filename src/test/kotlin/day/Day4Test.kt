package day

import day.Day4
import day.Passport
import getScanner
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.PrintStream
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNull

class Day4Test {

    private val outContent = ByteArrayOutputStream()

    @Test
    fun `can extract fields`() {
        assertEquals("1000", Passport.extractField("abc:1000 def:2000", "abc"))
        assertEquals("2000", Passport.extractField("abc:1000 def:2000", "def"))
        assertNull(Passport.extractField("abc:1000 def:2000", "ghi"))
    }

    @Test
    fun `can load example input and print correct output for part 1`() {
        val scanner = getScanner(4, "test")
        val printStream = PrintStream(outContent)
        Day4(scanner, printStream).solvePart1()
        val output = outContent.toString().trimMargin().toInt()
        assertEquals(2, output)
    }

    @Test
    fun `can load example input and print correct output for part 2 valid`() {
        val scanner = getScanner(4, "test", "inputValid")
        val printStream = PrintStream(outContent)
        Day4(scanner, printStream).solvePart2()
        val output = outContent.toString().trimMargin().toInt()
        assertEquals(4, output)
    }

    @Test
    fun `can load example input and print correct output for part 2 invalid`() {
        val scanner = getScanner(4, "test", "inputInvalid")
        val printStream = PrintStream(outContent)
        Day4(scanner, printStream).solvePart2()
        val output = outContent.toString().trimMargin().toInt()
        assertEquals(0, output)
    }

    private fun getScanner(dayNumber: Int, folder: String, fileName: String): Scanner {
        val input = File("src/$folder/resources/day$dayNumber/$fileName.txt")
        return if (input.exists()) {
            Scanner(input)
        } else {
            error("Please create an input.txt file inside resources/day$dayNumber")
        }
    }
}

