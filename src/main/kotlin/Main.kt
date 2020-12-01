import java.io.File
import java.io.PrintStream
import java.util.Scanner

fun main(args: Array<String>) {
    // expecting arguments of form: [day, i/o] eg. day1 file
    val day = if (args.isEmpty()) "" else args[0]
    val dayStringNumber = Regex("[0-9]+").find(day)
    if (dayStringNumber == null || dayStringNumber.value.toInt() !in 1..25) {
        println("Please enter a day number between 1 and 25")
        return
    }
    val dayNumber = dayStringNumber.value.toInt()

    val path = "src/main/resources/day$dayNumber/"
    val scanner = if (args.size == 1) Scanner(System.`in`) else Scanner(File(path + "input.txt"))
    val printStream = if (args.size == 1) PrintStream(System.out) else PrintStream(File(path + "output.txt"))

    DayProblemFactory.getDayProblem(dayNumber, scanner, printStream).solve()

    println("process complete.")
    println("exit...")
}