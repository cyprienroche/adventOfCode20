import java.io.File
import java.io.PrintStream
import java.time.LocalDate
import java.util.Scanner

fun main(args: Array<String>) {
    // expecting arguments of form: [day, i/o] eg. day1 file
    val today = LocalDate.now().dayOfMonth
//    val day = if (args.isEmpty()) "$today" else args[0]
    val day = "5"

    val dayStringNumber = Regex("[0-9]+").find(day)!!
    if (dayStringNumber.value.toInt() !in 1..25) error("Please enter a day number between 1 and 25")
    val dayNumber = dayStringNumber.value.toInt()

    solve(dayNumber, 1)
    solve(dayNumber, 2)

    println("\nprocess completed.")
    println("exit...")
}

private fun solve(day: Int, part: Int) {
    val scanner = getScanner(day, "main")
    val printStream = getPrintStreamPart(day, "main", part)
    val dayProblem = DayProblemFactory.getDayProblem(day, scanner, printStream)
    if (part == 1) dayProblem.solvePart1() else dayProblem.solvePart2()
}

fun getScanner(dayNumber: Int, folder: String): Scanner {
    val input = File("src/$folder/resources/day$dayNumber/input.txt")
    return if (input.exists()) {
        Scanner(input)
    } else {
        error("Please create an input.txt file inside resources/day$dayNumber")
    }
}

fun getPrintStreamPart(dayNumber: Int, folder: String, part: Int): PrintStream {
    val output = File("src/$folder/resources/day$dayNumber/output$part.txt")
    return if (output.exists()) {
        println("output$part.tx file detected for day $dayNumber. Will write solution to output$part.txt.")
        PrintStream(output)
    } else {
        println("no output$part.tx file detected day $dayNumber. Will write solution to console.")
        PrintStream(System.out)
    }
}
