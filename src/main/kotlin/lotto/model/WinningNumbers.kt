package lotto.model

import lotto.exception.ApplicationException
import lotto.exception.WinningNumbersException

class WinningNumbers(
    private val numbers: List<Int>,
    private val bonusNumber: Int,
) {
    init {
        if (numbers.size != 6) {
            throw ApplicationException(WinningNumbersException.INVALID_WINNING_NUMBERS)
        }
        if (numbers.contains(bonusNumber)) {
            throw ApplicationException(WinningNumbersException.BONUS_DUPLICATE)
        }
    }

    fun match(lotto: Lotto): Int {
        return lotto.getNumbers().count { it in numbers }
    }

    fun isBonusMatch(lotto: Lotto): Boolean {
        return bonusNumber in lotto.getNumbers()
    }
}