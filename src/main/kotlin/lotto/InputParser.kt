package lotto

object InputParser {

    fun parseToInt(input: String): Int {
        return input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
    }

    fun parseToNumbers(input: String): List<Int> {
        return input.split(",")
            .map { it.trim() }
            .map { it.toIntOrNull() ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.") }
    }
}
