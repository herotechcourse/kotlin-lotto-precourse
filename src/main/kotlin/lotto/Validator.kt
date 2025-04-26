package lotto

import lotto.constants.ErrorMessage
import lotto.constants.LottoPrice

object Validator {
    fun validatePurchaseAmount(input: String): Int {
        this.isNotBlank(input)
        this.isNumber(input)
        this.isDivisible(input)

        return input.toInt()
    }

    fun validateWinningNumbers(input: String): List<Int> {
        isNotBlank(input)
        val tokens: List<String> = input.split(',').map { it.trim() }
        validateCount(tokens)
        validateDuplication(tokens)

        return tokens.map {
            isNumber(it)
            val number = it.toInt()
            validateRange(number)
            number
        }
    }

    private fun isNotBlank(input: String) {
        if (input.isBlank()) {
            throw IllegalArgumentException(ErrorMessage.INPUT_IS_BLANK.message)
        }
    }

    private fun isNumber(input: String) {
        if (input.toIntOrNull() == null) {
            throw IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.message)
        }
    }

    private fun isDivisible(input: String) {
        if (input.toInt() % LottoPrice.TICKET != 0) {
            throw IllegalArgumentException(ErrorMessage.NOT_DIVISIBLE_BY_UNIT.message)
        }
    }

    private fun validateCount(input: List<String>) {
        if (input.size != 6) {
            throw IllegalArgumentException(ErrorMessage.INVALID_NUMBER_COUNT.message)
        }
    }

    private fun validateDuplication(input: List<String>) {
        val set = input.toSet()
        if (set.size != 6) {
            throw IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBERS.message)
        }
    }

    private fun validateRange(number: Int) {
        if (number < 1 || number > 45) {
            throw IllegalArgumentException(ErrorMessage.NUMBER_OUT_OF_RANGE.message)
        }
    }
}