package lotto.util

import lotto.exception.InputException

object Validator {

    fun validateAmount(input: String): Int {
        val number = input.toIntOrNull()
            ?: throw InputException.InvalidInteger()
        require(number >= 1000) { throw InputException.AmountTooSmall() }
        require(number % 1000 == 0) { throw InputException.AmountNotDivisible() }
        return number
    }

    fun validateWinningNumbers(input: String): List<Int> {
        val numbers = StringUtil.convertToList(input)
            .map {
                it.toIntOrNull() ?: throw InputException.InvalidInteger()
            }
        require(numbers.size == 6 && numbers.toSet().size == 6) {
            throw InputException.InvalidWinningNumbers()
        }
        require(numbers.all { it in 1..45 }) {
            throw InputException.NumberOutOfRange()
        }
        return numbers
    }

    fun validateBonusNumber(input: String): Int {
        val number = input.toIntOrNull()
            ?: throw InputException.InvalidInteger()
        require(number in 1..45) {
            throw InputException.NumberOutOfRange()
        }
        return number
    }
}
