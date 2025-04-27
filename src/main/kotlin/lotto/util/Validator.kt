package lotto.util

import lotto.exception.InputException

object Validator {

    fun validateAmount(input: String): Int {
        val number = input.toIntOrNull()
            ?: throw IllegalArgumentException(InputException.INVALID_INTEGER.getMessage())
        require(number >= 1000) { InputException.AMOUNT_TOO_SMALL.getMessage() }
        require(number % 1000 == 0) { InputException.AMOUNT_NOT_DIVISIBLE.getMessage() }
        return number
    }

    fun validateWinningNumbers(input: String): List<Int> {
        val numbers = input.split(",")
            .map {
                it.trim().toIntOrNull() ?: throw IllegalArgumentException(InputException.INVALID_INTEGER.getMessage())
            }
        require(numbers.size == 6 && numbers.toSet().size == 6) {
            InputException.INVALID_WINNING_NUMBERS.getMessage()
        }
        require(numbers.all { it in 1..45 }) {
            InputException.NUMBER_OUT_OF_RANGE.getMessage()
        }
        return numbers
    }

    fun validateBonusNumber(input: String): Int {
        val number = input.toIntOrNull()
            ?: throw IllegalArgumentException(InputException.INVALID_INTEGER.getMessage())
        require(number in 1..45) {
            InputException.NUMBER_OUT_OF_RANGE.getMessage()
        }
        return number
    }
}
