package solutions

import utils.readInput
import kotlin.math.pow

class Day04 {
    private var input = emptyList<String>()
    private data class Card(val id: Int, val winning: List<Int>, val actual: List<Int>)

    private fun parseInput(input: List<String>): List<Card> {
        return input.mapIndexed { index, line ->
            val (winning, actual) = line
                .substringAfter(':')
                .split("|")
                .map { numbers ->
                    numbers
                        .split(" ")
                        .filter(String::isNotBlank)
                        .map(String::toInt)
                }

            return@mapIndexed Card(index + 1, winning, actual)
        }
    }

    fun practice() {
        input = readInput("day04/Practice")
        //Part 1
        println("Part 1 is ${part01Solution()}")
        //Part 2
        println("Part 2 is ${part02Solution()}")
    }

    fun part01() {
        input = readInput("day04/Day04")
        println("Part 1 solution is ${part01Solution()}")
    }

    fun part02() {
        input = readInput("day04/Day04")
        println("Part 2 solution is ${part02Solution()}")
    }

    private fun part01Solution(): Int = parseInput(input).sumOf { card ->
        // 2 to the power of -1 is 0.5, so after converting it to an integer its 0
        2.toDouble().pow(card.actual.count(card.winning::contains) - 1).toInt()
    }

    private fun part02Solution(): Int {
        val cards = parseInput(input)
        val copies = cards
            .associate { it.id to 1 }
            .toMutableMap()

        cards.forEach { card ->
            val matching = card.actual.count(card.winning::contains)
            val cardsToCopy = (card.id + 1)..(card.id + matching)

            cardsToCopy.forEach { id ->
                copies[id] = copies[id]!! + copies[card.id]!!
            }
        }

        return copies.values.sum()
    }

    private val regex = """\d+""".toRegex()

    private fun Char.isSymbol(): Boolean {
        return !(this == '.' || isDigit() || isWhitespace())
    }
}