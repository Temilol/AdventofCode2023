package solutions

import utils.readInput

class Day03 {
    private var input = emptyList<String>()

    private fun computeGear(input: List<String>): Map<Pair<Int, Int>, List<Int>> {
        val map = mutableMapOf<Pair<Int, Int>, MutableList<Int>>()
        for ((index, line) in input.withIndex()) {
            for (match in regex.findAll(line)) {
                val number = match.value.toInt()
                for (i in (index - 1).coerceAtLeast(0)..(index + 1).coerceAtMost(input.lastIndex)) {
                    val l = match.range.first - 1
                    val r = match.range.last + 1
                    for (j in l.coerceAtLeast(0)..r.coerceAtMost(input[i].lastIndex)) {
                        if (input[i][j].isSymbol()) {
                            map.getOrPut(j to i) { mutableListOf() } += number
                        }
                    }
                }
            }
        }
        return map
    }

    fun practice() {
        input = readInput("day03/Practice")
        //Part 1
        println("Part 1 is ${part01Solution()}")
        //Part 2
        println("Part 2 is ${part02Solution()}")
    }

    fun part01() {
        input = readInput("day03/Day03")
        println("Part 1 solution is ${part01Solution()}")
    }

    fun part02() {
        input = readInput("day03/Day03")
        println("Part 2 solution is ${part02Solution()}")
    }

    private fun part01Solution(): Int = computeGear(input).values.sumOf { it.sum() }

    private fun part02Solution(): Int = computeGear(input).values.sumOf { if (it.size == 2) it[0] * it[1] else 0 }

    private val regex = """\d+""".toRegex()

    private fun Char.isSymbol(): Boolean {
        return !(this == '.' || isDigit() || isWhitespace())
    }
}