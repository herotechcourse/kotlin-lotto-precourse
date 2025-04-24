package lotto

import lotto.validator.InputValidator

class Lotto(private val numbers: List<Int>) {
    init {
        InputValidator.checkLottoSize(numbers)
        InputValidator.allNumbersInRange(numbers)
        InputValidator.noDuplicateNumbers(numbers)
    }

    override fun toString(): String {
        return numbers.toString()
    }

    fun getNumbers(): List<Int> = numbers
}
