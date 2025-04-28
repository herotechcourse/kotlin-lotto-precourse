package lotto.validation

import lotto.model.LOTTO_NUMBER_END
import lotto.model.LOTTO_NUMBER_START

object BonusNumberValidator {
    private const val ERROR_PREFIX: String = "[ERROR]"
    private const val PROMPT_AGAIN: String = "Please enter it again"

    private const val INVALID_RANGE = "$ERROR_PREFIX Input must be between 1 and 45. $PROMPT_AGAIN"
    private const val NOT_CONSIST_IF_WINNING_NUMBERS =
        "$ERROR_PREFIX Input must not consist of winning numbers. $PROMPT_AGAIN"

    fun validate(bonusNumber: String) {
        require(bonusNumber.isNotEmpty()) { ErrorMessage.EMPTY_INPUT.message }

        val digitRegex = Regex("\\d+")
        require(bonusNumber.matches(digitRegex)) { ErrorMessage.NOT_NUMBER_TYPE.message }

        require(bonusNumber.toInt() in LOTTO_NUMBER_START..LOTTO_NUMBER_END) { INVALID_RANGE }
    }

    fun validateDuplicateWithWinningNumbers(bonusNumber: String, winningNumbers: List<String>) {
        require((winningNumbers.find { it == bonusNumber }) == null) { NOT_CONSIST_IF_WINNING_NUMBERS }
    }
}
