import java.io.PrintStream
import java.lang.IllegalArgumentException
import java.util.Scanner
import day1.Day1
import day2.Day2
import day3.Day3
import day4.Day4
import day5.Day5

class DayProblemFactory {

    companion object {
        fun getDayProblem(dayNumber: Int, scanner: Scanner, printStream: PrintStream): Problem = when (dayNumber) {
            1 -> Day1(scanner, printStream)
            2 -> Day2(scanner, printStream)
            3 -> Day3(scanner, printStream)
            4 -> Day4(scanner, printStream)
            5 -> Day5(scanner, printStream)
            else -> throw IllegalArgumentException()
        }
    }
}