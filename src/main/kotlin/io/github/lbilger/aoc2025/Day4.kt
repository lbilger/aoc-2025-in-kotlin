package io.github.lbilger.aoc2025

import java.nio.file.Files
import java.nio.file.Paths

fun day4part1() {
    println("Day 4, Part 1")
    val input = Files.lines(Paths.get("inputs/Day4.txt")).toList().map { it.toList() }.toList()
    println("Input: ${input.size} lines")
    val sum = input.mapIndexed {  y, line ->
        line.filterIndexed {  x, char ->
            char == '@' && countAdjacent(input, x, y) <4
        }
            .count()
    }
        .sum()
    println(sum)
}

fun countAdjacent(input: List<List<Char>>, x: Int, y: Int): Int {
    var count = 0
    for (dy in -1..1) {
        for (dx in -1..1) {
            if (dx == 0 && dy == 0) continue
            val nx = x + dx
            val ny = y + dy
            if (ny in input.indices && nx in input[ny].indices) {
                if (input[ny][nx] == '@') {
                    count++
                }
            }
        }
    }
    return count
}

fun day4part2() {
    println("Day 4, Part 2")
    val input = Files.lines(Paths.get("inputs/Day4.txt")).toList().map { it.toMutableList() }
    println("Input: ${input.size} lines")
    var sum = 0
    var lastSum = -1
    while (sum != lastSum) {
        lastSum = sum
        input.forEachIndexed {  y, line ->
            line.forEachIndexed {  x, char ->
                if(char == '@' && countAdjacent(input, x, y) <4) {
                    sum++
                    line[x] = '.'
                }
            }
        }
    }
    println(sum)
}

fun main() {
    day4part1()
    day4part2()
}
