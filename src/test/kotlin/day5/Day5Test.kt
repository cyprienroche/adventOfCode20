package day5

import getScanner
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.PrintStream
import java.util.*
import kotlin.test.assertEquals
import kotlin.test.assertNull

class Day5Test {

    private val outContent = ByteArrayOutputStream()

    @Test
    fun `can encode boarding pass`() {
        val bp1 = encodeBoardingPass("BFFFBBFRRR")
        val bp2 = encodeBoardingPass("FFFBBBFRRR")
        val bp3 = encodeBoardingPass("BBFFBBFRLL")

        assertEquals(567, bp1.seatID)
        assertEquals(119, bp2.seatID)
        assertEquals(820, bp3.seatID)

        assertEquals(70, bp1.row)
        assertEquals(14, bp2.row)
        assertEquals(102, bp3.row)

        assertEquals(7, bp1.column)
        assertEquals(7, bp2.column)
        assertEquals(4, bp3.column)
    }

    @Test
    fun `can load example input and print correct output for part 1`() {
        val scanner = getScanner(5, "test")
        val printStream = PrintStream(outContent)
        Day5(scanner, printStream).solvePart1()
        val output = outContent.toString().trimMargin().toInt()
        assertEquals(820, output)
    }

    @Test
    fun `can find missing number`() {
        assertEquals(0b0101, missingNumber((0b0..(0b1111)).toList().filter { it != 0b0101 }))
        assertEquals(0b0101, missingNumber((0b0..(0b1111111)).toList().filter { it != 0b0101 }))
        assertEquals(0b0101, missingNumber((0b0..(0b1111111)).toList().filter { it != 0b0101 }))


        assertEquals(0b1111111, missingNumber((0b0..(0b1111111)).toList().filter { it != 0b1111111 }))
        assertEquals(0b0, missingNumber((0b0..(0b1111111)).toList().filter { it != 0b0 }))
    }
}