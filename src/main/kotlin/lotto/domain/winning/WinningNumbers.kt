package lotto.domain.winning

import lotto.Lotto
import lotto.common.CommonValidator
import lotto.exception.DomainException

class WinningNumbers private constructor(private val numbers: List<Int>) {
    init {
        require(numbers.size == VALID_SIZE) { DomainException.MUST_CONTAIN.format(VALID_SIZE) }
        require(numbers.size == numbers.distinct().size) { DomainException.MUST_NOT_BE_DUPLICATED.message() }
        require(isValidRange(numbers)) { DomainException.MUST_BE_VALID_RANGE.format(START_INCLUSIVE, END_INCLUSIVE) }
    }

    private fun isValidRange(numbers: List<Int>): Boolean {
        return numbers.all { it in START_INCLUSIVE..END_INCLUSIVE }
    }

    fun doNotContain(number: Int): Boolean = number !in numbers

    fun countMatches(lottoNumbers: Lotto): Int = lottoNumbers.numbers().count { it in numbers }

    companion object {
        private const val VALID_SIZE = 6
        private const val START_INCLUSIVE = 1
        private const val END_INCLUSIVE = 45
        private const val DELIMITER = ","

        fun from(numbers: String): WinningNumbers {
            val winningNumbers = numbers.split(DELIMITER)
                .map { it.trim() }
                .map { number -> CommonValidator.parseAndValidateNumber(number) }
                .toList()

            return WinningNumbers(winningNumbers)
        }
    }
}