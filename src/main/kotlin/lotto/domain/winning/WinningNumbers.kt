package lotto.domain.winning

import lotto.Lotto
import lotto.common.CommonValidator

class WinningNumbers(private val numbers: List<Int>) {
    init {
        require(numbers.size == VALID_SIZE) { "[ERROR] Winning numbers must contain exactly $VALID_SIZE numbers." }
        require(numbers.size == numbers.distinct().size) { "[ERROR] Winning Numbers must not be duplicated." }
        require(isValidRange(numbers)) { "[ERROR] Winning numbers must be between $START_INCLUSIVE and $END_INCLUSIVE." }
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