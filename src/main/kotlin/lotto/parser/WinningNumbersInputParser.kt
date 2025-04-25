package lotto.parser

class WinningNumbersInputParser {
    fun parse(input: String): List<Int> {
        val tokens = input.split(",").map { it.trim() }
        require(tokens.size == 6) { INVALID_WINNING_NUMBERS_SIZE }

        val numbers = tokens.map {
            require(it.toIntOrNull() != null) { INVALID_NUMBER_FORMAT }
            it.toInt()
        }

        return numbers
    }

    companion object {
        const val INVALID_WINNING_NUMBERS_SIZE = "[ERROR] Winning numbers must contain exactly 6 values."
        const val INVALID_NUMBER_FORMAT = "[ERROR] All winning numbers must be valid integers."
    }
}