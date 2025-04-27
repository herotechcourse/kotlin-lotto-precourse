package lotto.util

import lotto.exception.ApplicationException
import lotto.exception.InputException

object Validator {

    fun validateAmount(input: String): Int {
        val number = input.toIntOrNull()
            ?: throw ApplicationException(InputException.INVALID_INTEGER)
        require(number >= 1000) { throw ApplicationException(InputException.AMOUNT_TOO_SMALL) }
        require(number % 1000 == 0) { throw ApplicationException(InputException.AMOUNT_NOT_DIVISIBLE) }
        return number
    }

    fun validateWinningNumbers(input: String): List<Int> {
        val numbers = StringUtil.convertToList(input).map {
            it.toIntOrNull() ?: throw ApplicationException(InputException.INVALID_INTEGER)
        }
        if (numbers.size != 6 || numbers.toSet().size != 6) {
            throw ApplicationException(InputException.INVALID_WINNING_NUMBERS)
        }
        if (numbers.any { it !in 1..45 }) {
            throw ApplicationException(InputException.NUMBER_OUT_OF_RANGE)
        }
        return numbers
    }

    fun validateBonusNumber(input: String): Int {
        val number = input.toIntOrNull()
            ?: throw ApplicationException(InputException.INVALID_INTEGER)
        if (number !in 1..45) {
            throw ApplicationException(InputException.NUMBER_OUT_OF_RANGE)
        }
        return number
    }
}
