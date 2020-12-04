package day4

import Problem
import java.io.PrintStream
import java.lang.StringBuilder
import java.util.Scanner

class Day4(private val scanner: Scanner, private val printStream: PrintStream) : Problem {

    private fun nextRawPassportData(): String {
        var line: String
        val sb = StringBuilder()

        do {
            line = scanner.nextLine()
            sb.append(line).append(" ")
        } while (scanner.hasNext() && line.isNotBlank())

        return sb.toString()
    }

    private fun nextPassport(): Passport? {
        if (!scanner.hasNext()) return null
        val rawData = nextRawPassportData()
        return Passport.createFrom(rawData)
    }

    override fun solvePart1(): Unit {
        var count = 0
        while (scanner.hasNext()) {
            count += if (nextPassport() == null) 0 else 1
        }
        printStream.println(count)
    }

    override fun solvePart2(): Unit {
        var count = 0
        var passport: Passport?
        while (scanner.hasNext()) {
            passport = nextPassport()
            if (passport != null && passport.allFieldsValid()) count++
            println(passport)
            println(passport?.isValidPID())
        }
        printStream.println(count)
    }

}

data class Passport(
    val byr: String, /*(Birth Year)*/
    val iyr: String, /*(Issue Year)*/
    val eyr: String, /*(Expiration Year)*/
    val hgt: String, /*(Height)*/
    val hcl: String, /*(Hair Color)*/
    val ecl: String, /*(Eye Color)*/
    val pid: String, /*(Passport ID)*/
    val cid: String? /*(Country ID)*/
) {

    fun allFieldsValid(): Boolean = isValidBYR() &&
            isValidIYR() &&
            isValidEYR() &&
            isValidHGT() &&
            isValidHCL() &&
            isValidECL() &&
            isValidPID() &&
            isValidCID()

    // four digits; at least 1920 and at most 2002.
    fun isValidBYR(): Boolean = Regex("""\d{4}""").matches(byr) && byr.toInt() in 1920..2002

    // four digits; at least 2010 and at most 2020.
    fun isValidIYR(): Boolean = Regex("""\d{4}""").matches(iyr) && iyr.toInt() in 2010..2020

    // four digits; at least 2020 and at most 2030.
    fun isValidEYR(): Boolean = Regex("""\d{4}""").matches(eyr) && eyr.toInt() in 2020..2030

    /* a number followed by either cm or in:
       - If cm, the number must be at least 150 and at most 193.
       - If in, the number must be at least 59 and at most 76. */
    fun isValidHGT(): Boolean {
        val cm = Regex("""(\d+)cm""").find(hgt)
        val inch = Regex("""(\d+)in""").find(hgt)
        return when {
            cm != null -> {
                val (cmValue) = cm.destructured
                return cmValue.toInt() in 150..193
            }
            inch != null -> {
                val (inchValue) = inch.destructured
                return inchValue.toInt() in 59..76
            }
            else -> false
        }
    }

    // a # followed by exactly six characters 0-9 or a-f.
    fun isValidHCL(): Boolean = Regex("""#([0-9]|[a-f]){6}""").matches(hcl)

    // exactly one of: amb blu brn gry grn hzl oth.
    fun isValidECL(): Boolean = Regex("""(amb|blu|brn|gry|grn|hzl|oth)""").matches(ecl)

    // a nine-digit number, including leading zeroes.
    fun isValidPID(): Boolean = Regex("""\d{9}""").matches(pid)

    // ignored, missing or not.
    fun isValidCID(): Boolean = true

    companion object {
        fun createFrom(rawData: String): Passport? {
            val byr = extractField(rawData, "byr") ?: return null
            val iyr = extractField(rawData, "iyr") ?: return null
            val eyr = extractField(rawData, "eyr") ?: return null
            val hgt = extractField(rawData, "hgt") ?: return null
            val hcl = extractField(rawData, "hcl") ?: return null
            val ecl = extractField(rawData, "ecl") ?: return null
            val pid = extractField(rawData, "pid") ?: return null
            val cid = extractField(rawData, "cid")
            return Passport(byr, iyr, eyr, hgt, hcl, ecl, pid, cid)
        }

        fun extractField(rawData: String, field: String): String? {
            val pattern = """$field:([^\s]+)"""
            val match = Regex(pattern).find(rawData) ?: return null
            val (value) = match.destructured
            return value
        }
    }

}
