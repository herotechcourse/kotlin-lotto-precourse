package lotto

object InputParser {

    fun parseToInt(input: String): Int {
        return input.toIntOrNull()
            ?: throw IllegalArgumentException("[ERROR] Please enter a valid number.")
    }
}
