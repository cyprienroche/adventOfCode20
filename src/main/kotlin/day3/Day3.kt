package day3

import Problem
import java.io.PrintStream
import java.util.Scanner

class Day3(private val scanner: Scanner, private val printStream: PrintStream) : Problem {

    private fun load(): List<String> {
        val input = mutableListOf<String>()
        while (scanner.hasNext()) {
            input.add(scanner.nextLine())
        }
        return input
    }

    override fun solvePart1(): Unit = printStream.println(countTreesOnPath(1, 3, load()))

    override fun solvePart2() {
        val forest = load()
        // because of integer overflow, had to use Long
        val oneOne = countTreesOnPath(1, 1, forest).toLong()
        val oneThree = countTreesOnPath(1, 3, forest).toLong()
        val oneFive = countTreesOnPath(1, 5, forest).toLong()
        val oneSeven = countTreesOnPath(1, 7, forest).toLong()
        val twoOne = countTreesOnPath(2, 1, forest).toLong()
        printStream.println(oneOne * oneThree * oneFive * oneSeven * twoOne)
    }

}

const val TREE = '#'

fun countTreesOnPath(dy: Int, dx: Int, pattern: List<String>): Int =
    pattern.indices.filter { it % dy == 0 }.mapIndexed { index, i -> isTree(index * dx, pattern[i]) }.sum()


/*
position is the position
horizontalPattern is a horizontal chunk of the forest eg. . . # . . #
return 0 if false and 1 if true
*/
fun isTree(position: Int, horizontalPattern: String): Int =
    if (horizontalPattern[position % horizontalPattern.length] == TREE) 1 else 0
