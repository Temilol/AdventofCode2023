package solutions

import utils.readInput

class Day02 {
    private var games = emptyList<String>()

    fun practice() {
        //Part 1
        games = readInput("day02/Practice")
        println("Part 1 is ${part01Solution()}")
        //Part 2
        games = readInput("day02/Practice")
        println("Part 2 is ${part02Solution()}")
    }

    fun part01() {
        games = readInput("day02/Day02")
        println("Part 1 solution is ${part01Solution()}")
    }

    fun part02() {
        games = readInput("day02/Day02")
        println("Part 2 solution is ${part02Solution()}")
    }

    private fun part01Solution(): Int {
        var total = 0
        for (game in games) {
            val split = game.split(":").toTypedArray()
            val gameId = split[0].split(" ").toTypedArray()[1].toInt()
            val gameCubes = split[1].split(";").toTypedArray()
            var validGame = true
            for (gameCube in gameCubes) {
                var r = 12
                var g = 13
                var b = 14
                val cubes = gameCube.trim().split(",").toTypedArray()
                for (cube in cubes) {
                    val current = cube.trim().split(" ")
                    when {
                        current[1] == "blue" -> {
                            b -= current[0].toInt()
                        }

                        current[1] == "red" -> {
                            r -= current[0].toInt()
                        }

                        current[1] == "green" -> {
                            g -= current[0].toInt()
                        }
                    }
                }
                if (b < 0 || g < 0 || r < 0) {
                    validGame = false
                }
            }
            if (validGame) {
                total += gameId
            }
        }
        return total
    }

    private fun part02Solution(): Int {
        var total = 0
        for (game in games) {
            val split = game.split(":").toTypedArray()
            val gameCubes = split[1].split(";").toTypedArray()
            var r = 1
            var g = 1
            var b = 1
            for (gameCube in gameCubes) {
                val cubes = gameCube.trim().split(",").toTypedArray()
                for (cube in cubes) {
                    val current = cube.trim().split(" ")
                    when {
                        current[1] == "blue" -> {
                            if (current[0].toInt() > b)
                                b = current[0].toInt()
                        }

                        current[1] == "red" -> {
                            if (current[0].toInt() > r)
                                r = current[0].toInt()
                        }

                        current[1] == "green" -> {
                            if (current[0].toInt() > g)
                                g = current[0].toInt()
                        }
                    }
                }
            }
            total += (b*r*g)
        }
        return total
    }
}