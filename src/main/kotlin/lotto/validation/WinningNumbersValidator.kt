package lotto.validation

import lotto.model.LOTTO_NUMBER_END
import lotto.model.LOTTO_NUMBER_START
import lotto.model.WinningNumbersParser

object WinningNumbersValidator {
    private const val ERROR_PREFIX: String = "[ERROR]"
    private const val PROMPT_AGAIN: String = "Please enter it again. "

    private const val NOT_SIX_NUMBERS = "$ERROR_PREFIX Input must be 6 numbers. $PROMPT_AGAIN"
    private const val NOT_NUMBER_TYPE = "$ERROR_PREFIX Input must be a number. $PROMPT_AGAIN"
    private const val NOT_FIVE_COMMA = "$ERROR_PREFIX Input must consist of 5 comma. $PROMPT_AGAIN"
    private const val INVALID_RANGE = "$ERROR_PREFIX Each Input must be between 1 and 45. $PROMPT_AGAIN"

    fun validate(winningNumbers: String) {
        require(winningNumbers.isNotEmpty()) { ErrorMessage.EMPTY_INPUT.message }
        require(winningNumbers.count { it == ',' } == 5) { NOT_FIVE_COMMA }

        val parsedWinningNumbers = WinningNumbersParser.parse(winningNumbers)

        val digitRegex = Regex("\\d+")
        require(parsedWinningNumbers.all { it.matches(digitRegex) }) { NOT_NUMBER_TYPE }

        require(parsedWinningNumbers.all { it.toInt() in LOTTO_NUMBER_START..LOTTO_NUMBER_END }) { INVALID_RANGE }

        require(parsedWinningNumbers.map { it.trim() }.size == 6) { NOT_SIX_NUMBERS }
    }
}
