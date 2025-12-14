package io.github.lbilger.aoc2025

import java.nio.file.Files
import java.nio.file.Paths

fun day3part1() {
    println("Day 3, Part 1")
    val input = Files.lines(Paths.get("inputs/Day3.txt")).toList()
    println("Input: ${input.size} lines")
    val sum = input.sumOf { line ->
        val firstDigit = line.dropLast(1).max()
        val secondDigit = line.substringAfter(firstDigit).max()
        10* firstDigit.digitToInt() + secondDigit.digitToInt()
    }
    println(sum)
}

fun day3part2() {
    println("Day 3, Part 2")
    val input = Files.lines(Paths.get("inputs/Day3.txt")).toList()
    println("Input: ${input.size} lines")
    val sum = input.sumOf { line ->
        var rest = line
        var digits = ""
        for (i in 1..12) {
        val nextDigit = rest.dropLast(12-i).max()
            digits += nextDigit
            rest = rest.substringAfter(nextDigit)
        }
        digits.toLong()
    }
    println(sum)
}

fun main() {
    day3part1()
    day3part2()
}
