package lotto.domain

import lotto.constants.ErrorMessage
import lotto.constants.LottoConstants

object Validator {
    fun validatePurchaseAmount(input: String): Int {
        validateBlank(input)
        validateNumber(input)
        validateDivisibility(input)

        return input.toInt()
    }

    fun validateWinningNumbers(input: String): Set<Int> {
        validateBlank(input)
        val tokens: List<String> = input.split(',').map { it.trim() }
        validateCount(tokens)
        validateDuplication(tokens)

        return tokens.map {
            validateNumber(it)
            val number = it.toInt()
            validateRange(number)
            number
        }.toSet()
    }

    fun validateBonusNumber(input: String, winningNumbers: Set<Int>): Int {
        validateBlank(input)
        validateNumber(input)
        val number: Int = input.toInt()
        validateRange(number)
        validateDuplicateOfBonusNumber(number, winningNumbers)

        return number
    }

    private fun validateBlank(input: String) {
        if (input.isBlank()) {
            throw IllegalArgumentException(ErrorMessage.INPUT_IS_BLANK.message)
        }
    }

    private fun validateNumber(input: String) {
        if (input.toIntOrNull() == null) {
            throw IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.message)
        }
    }

    private fun validateDivisibility(input: String) {
        if (input.toInt() % LottoConstants.TICKET_PRICE != 0) {
            throw IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_BY_UNIT.message)
        }
    }

    private fun validateCount(input: List<String>) {
        if (input.size != LottoConstants.LOTTO_SIZE) {
            throw IllegalArgumentException(ErrorMessage.INVALID_NUMBER_COUNT.message)
        }
    }

    private fun validateDuplication(input: List<String>) {
        val set = input.toSet()
        if (set.size != LottoConstants.LOTTO_SIZE) {
            throw IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS.message)
        }
    }

    private fun validateRange(number: Int) {
        if (number < LottoConstants.MIN_NUMBER || number > LottoConstants.MAX_NUMBER) {
            throw IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.message)
        }
    }

    private fun validateDuplicateOfBonusNumber(bonusNumber: Int, winningNumbers: Set<Int>) {
        if (winningNumbers.contains(bonusNumber)) {
            throw IllegalArgumentException(ErrorMessage.DUPLICATE_BONUS_NUMBER.message)
        }
    }
}