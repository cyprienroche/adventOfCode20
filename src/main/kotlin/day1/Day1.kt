package day1

import Problem
import java.io.PrintStream
import java.util.Scanner

class Day1(private val scanner: Scanner, private val printStream: PrintStream): Problem {

    override fun solve(): Unit {
        if (scanner.hasNext()) printStream.println(scanner.next())
    }
}