package lotto

import lotto.domain.dto.NumbersDto
import lotto.exception.DomainException

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == VALID_SIZE) { DomainException.MUST_CONTAIN.format(VALID_SIZE) }
        require(numbers.size == numbers.distinct().size) { DomainException.MUST_NOT_BE_DUPLICATED.message() }
        require(isValidRange(numbers)) { DomainException.MUST_BE_VALID_RANGE.format(START_INCLUSIVE, END_INCLUSIVE) }
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
