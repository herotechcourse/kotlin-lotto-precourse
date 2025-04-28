package lotto.util

object StringParser {

    private const val INVALID_NUMBER_ERROR = "[ERROR] Input value must be a number."
    private const val INVALID_WINNING_NUMBERS_FORMAT_ERROR = "[ERROR] Please enter only numbers and commas."

    private const val WINNING_NUMBERS_FORMAT = "^[0-9,]*$"

    fun parseToInt(input: String): Int {
        val round = input.toIntOrNull()
        require(round != null) { INVALID_NUMBER_ERROR }
        return round
    }

    fun parseByDelimiter(input: String, delimiter: String): List<Int> {
        require(WINNING_NUMBERS_FORMAT.toRegex().matches(input)) { INVALID_WINNING_NUMBERS_FORMAT_ERROR }
        return input.split(delimiter)
            .map { parseToInt(it) }
    }
}
