package lotto.common

import lotto.exception.InputException

object CommonValidator {
    fun parseAndValidateNumber(input: String): Int {
        try {
            return input.toInt()
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException(InputException.MUST_BE_NUMBER.message())
        }
    }
}