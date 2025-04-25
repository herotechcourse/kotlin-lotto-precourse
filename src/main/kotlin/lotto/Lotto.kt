package lotto

import lotto.util.Validator

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
        validate(numbers);
    }


    private fun validate(numbers: List<Int>) {
        Validator.isEqualListSize(numbers, LOTTO_NUMBER_COUNT)
        Validator.isNotDuplicate(numbers)
        numbers.forEach { number ->
            Validator.isNumberWithinRange(number, LOTTO_NUMBER_MINIMUM, LOTTO_NUMBER_MAXIMUM);
        }
    }
    companion object {
        const val LOTTO_NUMBER_MINIMUM = 1
        const val LOTTO_NUMBER_MAXIMUM = 45
        const val LOTTO_NUMBER_COUNT = 6
    }

    fun getNumbers(): List<Int> = numbers
}
