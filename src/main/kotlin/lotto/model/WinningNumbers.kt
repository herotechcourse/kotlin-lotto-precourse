package lotto.model

import lotto.Lotto
import lotto.constants.LottoConstants.LOTTO_NUMBER_COUNT
import lotto.exception.ApplicationException
import lotto.exception.WinningNumbersException

class WinningNumbers(
    private val numbers: List<Int>,
    private val bonusNumber: Int,
) {
    init {
        if (numbers.size != LOTTO_NUMBER_COUNT)
            throw ApplicationException(WinningNumbersException.INVALID_WINNING_NUMBERS)
        if (bonusNumber in numbers)
            throw ApplicationException(WinningNumbersException.BONUS_DUPLICATE)
    }

    fun match(lotto: Lotto): Int {
        return lotto.getNumbers().count { it in numbers }
    }

    fun isBonusMatch(lotto: Lotto): Boolean {
        return bonusNumber in lotto.getNumbers()
    }
}
