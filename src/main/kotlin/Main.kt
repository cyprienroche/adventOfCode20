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

    val scanner = if (args.size == 1) Scanner(System.`in`) else getScanner(dayNumber, "main")
    val printStream = if (args.size == 1) PrintStream(System.out) else getPrintStream(dayNumber, "main")

    DayProblemFactory.getDayProblem(dayNumber, scanner, printStream).solve()

    println("process complete.")
    println("exit...")
}

fun getScanner(dayNumber: Int, folder: String) = Scanner(File("src/$folder/resources/day$dayNumber/input.txt"))

fun getPrintStream(dayNumber: Int, folder: String) = PrintStream(File("src/$folder/resources/day$dayNumber/output.txt"))