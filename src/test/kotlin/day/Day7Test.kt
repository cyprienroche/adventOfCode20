package day

import getScanner
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import java.util.*
import kotlin.test.assertEquals

class Day7Test {

    private val outContent = ByteArrayOutputStream()

    @Test
    fun `can parse line and add to map`() {
        val scanner = getScanner(7, "test")
        val printStream = PrintStream(outContent)
        // scanner and print stream not used in this test
        val day = Day7(scanner, printStream)

        val dottedBlack = Bag("dotted", "black")
        val vibrantPlum = Bag("vibrant", "plum")
        val fadedBlue = Bag("faded", "blue")

        day.addBagFromString("${dottedBlack.pattern} ${dottedBlack.colour} bags contain no other bags.")
        day.addBagFromString("vibrant plum bags contain 5 faded blue bags, 6 dotted black bags.")

        val expectedMap = mapOf(fadedBlue to 5, dottedBlack to 6)
        assertEquals(mapOf(), day.bagsInside[dottedBlack])
        assertEquals(expectedMap, day.bagsInside[vibrantPlum])

        assertEquals(mapOf(vibrantPlum to 6), day.bagsOutside[dottedBlack])
        assertEquals(mapOf(vibrantPlum to 5), day.bagsOutside[fadedBlue])
        assertEquals(null, day.bagsOutside[vibrantPlum])
    }

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
        assertEquals(32, output)
    }


}