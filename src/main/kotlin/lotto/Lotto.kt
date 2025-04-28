package lotto

import lotto.domain.dto.NumbersDto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == VALID_SIZE) { "[ERROR] Lotto must contain exactly $VALID_SIZE numbers." }
        require(numbers.size == numbers.distinct().size) { "[ERROR] Lotto must not contain distinct numbers." }
        require(isValidRange(numbers)) { "[ERROR] Winning numbers must be between $START_INCLUSIVE and $END_INCLUSIVE." }
    }

    private fun isValidRange(numbers: List<Int>): Boolean {
        return numbers.all { it in START_INCLUSIVE..END_INCLUSIVE }
    }

    fun toNumbersDto(): NumbersDto = NumbersDto(numbers.toList())

    fun numbers() = numbers.toList()

    companion object {
        private const val VALID_SIZE = 6
        private const val START_INCLUSIVE = 1
        private const val END_INCLUSIVE = 45
    }
}
