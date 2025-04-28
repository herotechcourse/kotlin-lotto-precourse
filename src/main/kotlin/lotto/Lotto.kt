package lotto

import lotto.domain.BonusNumber
import lotto.domain.ErrorMessages
import lotto.domain.WinningNumbers

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == 6) { "[ERROR] Lotto must contain exactly 6 numbers." }

        require(numbers.distinct().size == 6) { ErrorMessages.INVALID_WINNING_NUMBERS_DUPLICATED }

        numbers.forEach {
            require(it in 1..45) { ErrorMessages.INVALID_NUMBERS_RANGE }
        }
    }

    fun getNumbers(): List<Int> = numbers

    fun matchCount(winning: WinningNumbers): Int = numbers.count { it in winning.numbers }

    fun containsNumber(bonus: BonusNumber): Boolean = numbers.contains(bonus.number)
}
