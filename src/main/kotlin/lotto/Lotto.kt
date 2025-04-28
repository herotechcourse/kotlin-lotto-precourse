package lotto

import lotto.domain.dto.NumbersDto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == VALID_SIZE) { "[ERROR] Lotto must contain exactly $VALID_SIZE numbers." }
        require(numbers.size == numbers.distinct().size) { "[ERROR] Lotto must not contain distinct numbers." }
    }

    fun toNumbersDto(): NumbersDto = NumbersDto(numbers.toList())

    companion object {
        private const val VALID_SIZE = 6
    }
}
