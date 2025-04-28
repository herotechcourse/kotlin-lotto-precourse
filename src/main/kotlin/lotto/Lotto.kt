package lotto

import lotto.LottoConstants.MAX_NUMBER
import lotto.LottoConstants.MIN_NUMBER
import lotto.LottoConstants.NUMBERS_PER_TICKET
import lotto.domain.BonusNumber
import lotto.domain.ErrorMessages
import lotto.domain.WinningNumbers

class Lotto(private val numbers: List<Int>) {
    init {
        require(numbers.size == NUMBERS_PER_TICKET) { "[ERROR] Lotto must contain exactly 6 numbers." }

        require(numbers.distinct().size == NUMBERS_PER_TICKET) { ErrorMessages.INVALID_WINNING_NUMBERS_DUPLICATED }

        numbers.forEach {
            require(it in MIN_NUMBER..MAX_NUMBER) { ErrorMessages.INVALID_NUMBERS_RANGE }
        }
    }

    fun getNumbers(): List<Int> = numbers

    fun matchCount(winning: WinningNumbers): Int = numbers.count { it in winning.numbers }

    fun containsNumber(bonus: BonusNumber): Boolean = numbers.contains(bonus.number)
}
