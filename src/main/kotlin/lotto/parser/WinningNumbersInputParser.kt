package lotto.parser

class WinningNumbersInputParser {
    fun parse(input: String): List<Int> {
        val tokens = input.split(DELIMITER).map { it.trim() }
        require(tokens.size == REQUIRED_SIZE) { INVALID_WINNING_NUMBERS_SIZE }

        val numbers = tokens.map {
            require(it.toIntOrNull() != null) { INVALID_NUMBER_FORMAT }
            it.toInt()
        }

        return numbers
    }

    companion object {
        const val DELIMITER = ","
        const val REQUIRED_SIZE = 6

        const val INVALID_WINNING_NUMBERS_SIZE = "[ERROR] Winning numbers must contain exactly 6 values."
        const val INVALID_NUMBER_FORMAT = "[ERROR] All winning numbers must be valid integers."
    }
}
