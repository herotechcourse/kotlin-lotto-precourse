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

    fun countMatch(winning: List<Int>): Int {
        return numbers.count { it in winning }
    }

    fun isContainsNumber(number: Int): Boolean {
        return numbers.contains(number)
    }
}
