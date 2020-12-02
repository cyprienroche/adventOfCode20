import java.io.PrintStream
import java.lang.IllegalArgumentException
import java.util.Scanner
import day1.Day1
import day2.Day2

class DayProblemFactory {

    companion object {
        fun getDayProblem(dayNumber: Int, scanner: Scanner, printStream: PrintStream): Problem = when (dayNumber) {
            1 -> Day1(scanner, printStream)
            2 -> Day2(scanner, printStream)
            else -> throw IllegalArgumentException()
        }
    }
}