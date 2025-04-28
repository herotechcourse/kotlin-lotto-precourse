package lotto

import lotto.validation.LottoValidator

class Lotto(private val numbers: List<Int>) {
    init {
        LottoValidator.validateLottoNumbers(numbers)
    }

    /** Returns the lotto numbers, sorted in ascending order. */
    fun getNumbers(): List<Int> {
        return numbers.sorted() // Always return sorted numbers
    }

    /** Checks if the Lotto ticket contains the given number. */
    fun contains(number: Int): Boolean {
        LottoValidator.validateNumberRange(number)
        return numbers.contains(number)
    }

    /** Counts how many numbers in this Lotto ticket match the given winning numbers. */
    fun countMatchingNumbers(winningNumbers: List<Int>): Int {
        return numbers.count { winningNumbers.contains(it) }
    }
}