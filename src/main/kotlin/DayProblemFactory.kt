import day.Day1
import day.Day2
import day.Day3
import day.Day4
import day.Day5
import day.Day6
import day.Day7
import java.io.PrintStream
import java.lang.IllegalArgumentException
import java.util.Scanner

class DayProblemFactory {

    companion object {
        fun getDayProblem(dayNumber: Int, scanner: Scanner, printStream: PrintStream): Problem = when (dayNumber) {
            1 -> Day1(scanner, printStream)
            2 -> Day2(scanner, printStream)
            3 -> Day3(scanner, printStream)
            4 -> Day4(scanner, printStream)
            5 -> Day5(scanner, printStream)
            6 -> Day6(scanner, printStream)
            7 -> Day7(scanner, printStream)
            else -> throw IllegalArgumentException()
        }
    }
}