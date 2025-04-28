package lotto.utils

import lotto.view.messages.PurchaseErrorMessage
import lotto.view.messages.WinningNumberErrorMessage

class InputValidator {

    fun validatePurchaseInput(input: String): Int {

        val amount = parseToIntOrThrow(input, PurchaseErrorMessage.NOT_A_NUMBER.message)
        if (amount < 0) {
            throw IllegalArgumentException(PurchaseErrorMessage.NEGATIVE_NUMBER.message)
        }
        if (amount < 1000) {
            throw IllegalArgumentException(PurchaseErrorMessage.LESS_THAN_MINIMUM.message)
        }
        if (amount % 1000 != 0) {
            throw IllegalArgumentException(PurchaseErrorMessage.NOT_A_MULTIPLE_OF_1000.message)
        }

        return amount
    }

    fun validateWinningNumbers(input: String): Set<Int> {

        val numbers = input.split(",")
            .map { parseToIntOrThrow(it, WinningNumberErrorMessage.NOT_A_NUMBER.message) }
        if (numbers.size != 6) {
            throw IllegalArgumentException(WinningNumberErrorMessage.NOT_SIX_NUMBERS.message)
        }
        numbers.forEach { validateLottoNumberRange(it, WinningNumberErrorMessage.NOT_IN_RANGE.message) }
        if (numbers.toSet().size != numbers.size) {
            throw IllegalArgumentException(WinningNumberErrorMessage.DUPLICATE_NUMBER.message)
        }

        return numbers.toSet()
    }

    fun validateBonusNumber(input: String, winningNumbers: Set<Int>): Int {

        val bonus = parseToIntOrThrow(input, WinningNumberErrorMessage.NOT_A_NUMBER.message)
        validateLottoNumberRange(bonus, WinningNumberErrorMessage.NOT_IN_RANGE.message)
        if (bonus in winningNumbers) {
            throw IllegalArgumentException(WinningNumberErrorMessage.BONUS_NUMBER_DUPLICATE.message)
        }

        return bonus
    }

    private fun parseToIntOrThrow(input: String, errorMessage: String): Int {
        return input.trim().toIntOrNull()
            ?: throw IllegalArgumentException(errorMessage)
    }

    private fun validateLottoNumberRange(number: Int, errorMessage: String) {
        if (number !in 1..45) {
            throw IllegalArgumentException(errorMessage)
        }
    }

}