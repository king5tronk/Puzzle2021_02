import java.io.File

class Day02 {


    fun part1(input: List<String>): Int {
        var depth = 0
        var horizontal = 0

        input.asSequence()
            .map { it.split(" ") }
            .forEach { (keyWord, parameter) ->
                val value = parameter.toInt()
                when (keyWord) {
                    "forward" -> horizontal += value
                    "up" -> depth -= value
                    "down" -> depth += value
                }
            }
        return depth * horizontal
    }
    fun part2(input: List<String>): Int {
        var depth = 0
        var horizontal = 0
        var aim = 0

        input.asSequence()
            .map { it.split(" ") }
            .forEach { (keyWord, parameter) ->
                val value = parameter.toInt()
                when (keyWord) {
                    "forward" -> {
                        horizontal += value
                        depth += aim * value
                    }
                    "up" -> aim -= value
                    "down" -> aim += value
                }
            }
        return depth * horizontal
    }
}
fun readFileAsLinesUsingUseLines(fileName: String): List<String>
        = File(fileName).useLines { it.toList() }

fun main(args: Array<String>) {
    val stringArray = readFileAsLinesUsingUseLines("src/main/resources/input.txt")
    val day02 = Day02()

    println(day02.part1(stringArray))
    println(day02.part2(stringArray))
}