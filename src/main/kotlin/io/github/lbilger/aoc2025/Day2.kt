package io.github.lbilger.aoc2025

import java.nio.file.Files
import java.nio.file.Paths

fun day2part1() {
    println("Day 2, Part 1")
    val input = Files.lines(Paths.get("inputs/Day2.txt")).toList()
    println("Input: ${input.size} lines")
    val sum = input.first()
        .split(",")
        .map { it.split("-") }
        .flatMap { it[0].toLong()..it[1].toLong() }
        .map { it.toString() }
        .filter { it.length % 2 == 0 && it.substring(0, it.length / 2) == it.substring(it.length / 2) }
        .sumOf { it.toLong() }
    println(sum)
}

fun day2part2() {
    println("Day 2, Part 2")
    val input = Files.lines(Paths.get("inputs/Day2.txt")).toList()
    println("Input: ${input.size} lines")
    val sum = input.first()
        .split(",")
        .map { it.split("-") }
        .flatMap { it[0].toLong()..it[1].toLong() }
        .map { it.toString() }
        .filter {
            (2..it.length).any { repeats ->
                it.length % repeats == 0 && (0 until repeats - 1).all { repeat ->
                    it.substring(
                        repeat * it.length / repeats,
                        (repeat + 1) * it.length / repeats
                    ) == it.substring((repeat + 1) * it.length / repeats, (repeat + 2) * it.length / repeats)
                }
            }
        }
        .sumOf { it.toLong() }
    println(sum)
}

fun main() {
    day2part1()
    day2part2()
}
