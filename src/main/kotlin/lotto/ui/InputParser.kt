package lotto.ui

import lotto.util.Constants

class InputParser {
    companion object{
        fun parseWinningNumbers(input: String): List<Int> {
            val numbers = input
                .split(",")
                .map {
                    it.trim().toIntOrNull()
                        ?: throw IllegalArgumentException(Constants.ERROR_INVALID_WINNING_NUMBER)
                }
            return numbers
        }
    }
}