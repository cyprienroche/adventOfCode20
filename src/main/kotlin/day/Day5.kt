package day

import Problem
import java.io.PrintStream
import java.lang.StringBuilder
import java.util.Scanner

class Day5(private val scanner: Scanner, private val printStream: PrintStream) : Problem {

    private fun load(): List<String> {
        val input = mutableListOf<String>()
        while (scanner.hasNext()) {
            input.add(scanner.nextLine())
        }
        return input
    }

    override fun solvePart1(): Unit {
        val bps = load().map { encodeBoardingPass(it) }
        printStream.println(bps.maxByOrNull { it.seatID }?.seatID)
    }

    override fun solvePart2(): Unit {
        val seats = load().map { encodeBoardingPass(it).seatID }.sortedBy { it }
        (0 until seats.size - 1).forEach { index ->
            if (seats[index + 1] - seats[index] > 1) {
                (1 until (seats[index + 1] - seats[index])).forEach { i -> printStream.println(seats[index] + i) }
            }
        }
    }

}

fun missingNumber(xs: List<Int>): Int {
    return xs.reduce {acc, i -> acc xor i}
}

fun encodeBoardingPass(boardingPass: String): BoardingPass {
    val seatID = boardingPass.map { if (it == 'B' || it == 'R') 0b1 else 0b0 }.reduce{ acc, i -> acc shl 1 or i}
    val row = (seatID and 0b111.inv()) shr 3
    val column = seatID and 0b111
    return BoardingPass(boardingPass, seatID, row, column)
}

data class BoardingPass(val value: String, val seatID: Int, val row: Int, val column: Int)