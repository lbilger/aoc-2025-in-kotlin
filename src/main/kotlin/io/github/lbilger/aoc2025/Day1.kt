package io.github.lbilger.aoc2025

import java.nio.file.Files
import java.nio.file.Paths

fun part1() {
    println("Day 1, Part 1")
    val input = Files.lines(Paths.get("inputs/Day1.txt")).toList()
    println("Input: ${input.size} lines")
    var current = 50
    var zeros = 0
    input.forEach {
        val direction = if (it.first() == 'L') -1 else 1
        val distance = it.drop(1).toInt()
        current = (current + direction * distance + 100) % 100
        if (current == 0) zeros++
    }
    println(zeros)
}

fun part2() {
    println("Day 1, Part 2")
    val input = Files.lines(Paths.get("inputs/Day1.txt")).toList()
    println("Input: ${input.size} lines")
    var current = 50
    var zeros = 0
    input.forEach {
        val direction = if (it.first() == 'L') -1 else 1
        val distance = it.drop(1).toInt()
        repeat(distance) {
            current = (current + direction + 100) % 100
            if (current == 0) {
                zeros++
            }
        }
    }
    println(zeros)
}

fun main() {
    println(-1 % 100)
    part1()
    part2()
}
