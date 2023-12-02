package solutions

import utils.readInput

class Day01 {
    private var calibrations = readInput("day01/Day01")

    fun practice() {
        //Part 1
        calibrations = readInput("day01/Practice")
        println("Part 1 is ${part01Solution()}")
        //Part 2
        calibrations = readInput("day01/Practice2")
        println("Part 2 is ${part02Solution()}")
    }

    fun part01() {
        calibrations = readInput("day01/Day01")
        println("Part 1 is ${part01Solution()}")
    }

    fun part02() {
        calibrations = readInput("day01/Day01")
        println("Part 2 is ${part02Solution()}")
    }

    private fun part01Solution(): Int {
        var total = 0
        for (calibration in calibrations) {
            var l = 0
            var r = calibration.length - 1
            while (l < r) {
                val calibrationL = calibration[l]
                val calibrationR = calibration[r]
                if(calibrationL.isDigit() && calibrationR.isDigit()) {
                    break
                }
                if (!calibrationL.isDigit()) {
                    l++
                }
                if (!calibrationR.isDigit()) {
                    r--
                }
            }
            val calibrationValue = (calibration[l].toString() + calibration[r]).toInt()
            total += calibrationValue
        }
        return total
    }

    private fun part02Solution(): Int {
        var total = 0
        for (calibration in calibrations) {
            val transformed = calibration
                .replace("one", "o1e")
                .replace("two", "t2o")
                .replace("three", "t3e")
                .replace("four", "f4r")
                .replace("five", "f5e")
                .replace("six", "s6x")
                .replace("seven", "s7n")
                .replace("eight", "e8t")
                .replace("nine", "n9e")

            var l = 0
            var r = transformed.length - 1
            while (l < r) {
                val calibrationL = transformed[l]
                val calibrationR = transformed[r]
                if(calibrationL.isDigit() && calibrationR.isDigit()) {
                    break
                }
                if (!calibrationL.isDigit()) {
                    l++
                }
                if (!calibrationR.isDigit()) {
                    r--
                }
            }
            val calibrationValue = (transformed[l].toString() + transformed[r]).toInt()
            total += calibrationValue
        }
        return total
    }
}