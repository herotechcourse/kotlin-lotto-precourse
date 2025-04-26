package lotto

import lotto.domain.dto.NumbersDto

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }
    }

    fun toNumbersDto(): NumbersDto = NumbersDto(numbers.toList())
}
