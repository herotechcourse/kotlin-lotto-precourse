package lotto.validation

import lotto.model.LOTTO_NUMBER_END
import lotto.model.LOTTO_NUMBER_START

object BonusNumberValidator {
    private const val ERROR_PREFIX: String = "[ERROR]"
    private const val PROMPT_AGAIN: String = "Please enter it again"

    private const val EMPTY_INPUT = "$ERROR_PREFIX There is no input. $PROMPT_AGAIN"
    private const val NOT_NUMBER_TYPE = "$ERROR_PREFIX Bonus number must be a number. $PROMPT_AGAIN"
    private const val INVALID_RANGE = "$ERROR_PREFIX Bonus number must be between 1 and 45. $PROMPT_AGAIN"
    private const val NOT_CONSIST_IF_WINNING_NUMBERS =
        "$ERROR_PREFIX Bonus number must not consist of winning numbers. $PROMPT_AGAIN"

    fun validate(bonusNumber: String) {
        require(bonusNumber.isNotEmpty()) { EMPTY_INPUT }

        val digitRegex = Regex("\\d+")
        require(bonusNumber.matches(digitRegex)) { NOT_NUMBER_TYPE }

        require(bonusNumber.toInt() in LOTTO_NUMBER_START..LOTTO_NUMBER_END) { INVALID_RANGE }
    }

    fun validateDuplicateWithWinningNumbers(bonusNumber: String, winningNumbers: List<String>) {
        require((winningNumbers.find { it == bonusNumber }) == null) { NOT_CONSIST_IF_WINNING_NUMBERS }
    }
}
