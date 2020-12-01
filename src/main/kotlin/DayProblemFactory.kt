import java.io.PrintStream
import java.lang.IllegalArgumentException
import java.util.Scanner
import day1.Day1

class DayProblemFactory {

    companion object {
        fun getDayProblem(dayNumber: Int, scanner: Scanner, printStream: PrintStream): Problem = when (dayNumber) {
            1 -> Day1(scanner, printStream)
            else -> throw IllegalArgumentException()
        }
    }
}