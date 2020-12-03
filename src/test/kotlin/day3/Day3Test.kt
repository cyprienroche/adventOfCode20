package day3

import getScanner
import org.junit.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.test.assertEquals

class Day3Test {

    private val outContent = ByteArrayOutputStream()

    @Test
    fun `can count trees following gradient right 3 down 1`() {
        assertEquals(0, countTreesOnPath(1, 3, listOf(".#######")))
        assertEquals(1, countTreesOnPath(1, 3, listOf(".#######", "########")))

        val forest = listOf(
            ".##..##.",
            "........",
            "########",
            ".#.#.#.#",
            "........",
            "########"
        )
        assertEquals(3, countTreesOnPath(1, 3, forest))
    }

    @Test
    fun `can load example input and print correct output for part 1`() {
        val scanner = getScanner(3, "test")
        val printStream = PrintStream(outContent)
        Day3(scanner, printStream).solvePart1()
        val output = outContent.toString().trimMargin().toInt()
        assertEquals(7, output)
    }

    @Test
    fun `can count trees following gradient right 5 down 1`() {
        assertEquals(0, countTreesOnPath(1,5, listOf(".#######")))
        assertEquals(1, countTreesOnPath(1,5, listOf(".#######", "########")))

        val forest = listOf(
            ".##..##.",
            "........",
            "########",
            ".#.#.#.#",
            "....#...",
            "########"
        )
        assertEquals(4, countTreesOnPath(1, 5, forest))
    }

    @Test
    fun `can count trees following gradient right 1 down 2`() {
        assertEquals(0, countTreesOnPath(2,1, listOf(".#######")))
        assertEquals(0, countTreesOnPath(2,1, listOf(".#######", "########")))

        val forest = listOf(
            ".##..##.",
            "........",
            "########",
            ".#.#.#.#",
            "....#...",
            "########"
        )
        assertEquals(1, countTreesOnPath(2, 1, forest))
    }

    @Test
    fun `can load example input and print correct output for part 2`() {
        val scanner = getScanner(3, "test")
        val printStream = PrintStream(outContent)
        Day3(scanner, printStream).solvePart2()
        val output = outContent.toString().trimMargin().toInt()
        assertEquals(336, output)
    }
}