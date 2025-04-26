package lotto

import lotto.util.Validator

class Lotto(private val numbers: List<Int>) {
    init {
        Validator.validateLottoNumbers(numbers)
    }

    fun getNumbers(): List<Int> = numbers.sorted()

    fun countMatching(winningNumbers: List<Int>): Int {
        return numbers.count { it in winningNumbers }
    }

    fun contains(number: Int): Boolean {
        return number in numbers
    }

}
