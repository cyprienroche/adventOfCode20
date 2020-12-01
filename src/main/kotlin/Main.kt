import java.io.File
import java.io.PrintStream
import java.util.*


fun main(args: Array<String>) {
    var scanner: Scanner
    var printStream: PrintStream

    if (args.isEmpty() || args[0] == "System") {
        scanner = Scanner(System.`in`)
    } else {
        val fileIn = File(args[0])
        scanner = Scanner(fileIn)
    }

    if (args.size < 2 || args[1] == "System") {
        printStream = PrintStream(System.out)
    } else {
        val fileOut = File(args[1])
        printStream = PrintStream(fileOut)
    }

    println("process complete.\nexit...")
    println("exit...")
}