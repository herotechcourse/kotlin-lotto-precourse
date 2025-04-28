package lotto.domain.validator

import lotto.constants.ErrorMessage
import lotto.constants.LottoConstants

object InputValidator {
    fun validatePurchaseAmount(input: String): Int {
        validateBlank(input)
        validateNumber(input)
        validateDivisibility(input)

        return input.toInt()
    }

    fun validateWinningNumbers(input: String): Set<Int> {
        validateBlank(input)
        val tokens: List<String> = input.split(',').map { it.trim() }
        Validator.validateCount(tokens)
        Validator.validateDuplication(tokens)

        return tokens.map {
            validateNumber(it)
            val number = it.toInt()
            Validator.validateRange(number)
            number
        }.toSet()
    }

    fun validateBonusNumber(input: String, winningNumbers: Set<Int>): Int {
        validateBlank(input)
        validateNumber(input)
        val number: Int = input.toInt()
        Validator.validateRange(number)
        Validator.validateDuplicateOfBonusNumber(number, winningNumbers)

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
}