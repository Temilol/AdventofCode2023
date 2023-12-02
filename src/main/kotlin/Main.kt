import solutions.Day01
import solutions.Day02

fun main(args: Array<String>) {
    println("============================================================================================")
    println("************************************  DAY 01!  *********************************************")
    println("** Day01 Practice Test Case **")
    val day1 = Day01()
    day1.practice()
    println("** Day01 Real Test Case **")
    println("Part 1 problem is https://adventofcode.com/2023/day/1")
    println("Part 1 solution is ${day1.part01()}")
    println("Part 2 problem is https://adventofcode.com/2023/day/1#part2")
    println("Part 2 solution is ${day1.part02()}")
    println("********************************************************************************************")
    println("************************************  DAY 02!  *********************************************")
    println("** Day02 Practice Test Case **")
    val day2 = Day02()
    day2.practice()
    println("** Day02 Real Test Case **")
    println("Part 1 problem is https://adventofcode.com/2023/day/2")
    day2.part01()
    println("Part 2 problem is https://adventofcode.com/2023/day/2#part2")
    day2.part02()
    println("********************************************************************************************")
}