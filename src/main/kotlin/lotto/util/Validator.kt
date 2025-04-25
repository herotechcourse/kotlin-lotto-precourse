package lotto.util

import lotto.enums.ErrorMessage

object Validator {

    fun isEmptyInput(input: String?) {
        if (input.isNullOrBlank()) {
            throw IllegalArgumentException(ErrorMessage.ERR_EMPTY_INPUT.message)
        }
    }

    fun isDigitString(input: String) {
        if (input.any { !it.isDigit() }) {
            throw IllegalArgumentException(ErrorMessage.ERR_IS_NOT_DIGIT_STRING.message)
        }
    }

    fun isNumberWithinRange(number: Int, minNumber: Int, maxNumber: Int) {
        if (number < minNumber || number > maxNumber) {
            throw IllegalArgumentException(ErrorMessage.ERR_INVALID_NUMBER_RANGE.message)
        }
    }

    fun isInteger(input: String): Int {
        return input.toIntOrNull()
            ?: throw IllegalArgumentException(ErrorMessage.ERR_IS_NOT_INTEGER_RANGE.message)
    }

    fun isDivisibleBy(number: Int, divisor: Int) {
        if (number % divisor != 0) {
            throw IllegalArgumentException(ErrorMessage.ERR_IS_NOT_DIVISIABLE_INPUT.message)
        }
    }

    fun <T> isEqualListSize(list: List<T>, winningNumberCount: Int) {
        if (list.size != winningNumberCount) {
            throw IllegalArgumentException(ErrorMessage.ERR_IS_NOT_SAME_WITH_LIST_SIZE.message)
        }
    }

    fun <T> isNotDuplicate(inputs: List<T>) {
        val uniqueNumbers = mutableSetOf<T>()
        for (input in inputs) {
            if (!uniqueNumbers.add(input)) {
                throw IllegalArgumentException(ErrorMessage.ERR_IS_DUPLICATED.message)
            }
        }
    }

    fun <T> isNotInList(list: List<T>, input: T) {
        if (list.contains(input)) {
            throw IllegalArgumentException(ErrorMessage.ERR_IS_DUPLICATED.message)
        }
    }
}
