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
}