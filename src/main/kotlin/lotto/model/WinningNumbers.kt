package lotto.model

import lotto.constants.LottoConstants.LOTTO_NUMBER_COUNT
import lotto.exception.WinningNumbersException

class WinningNumbers(
    private val numbers: List<Int>,
    private val bonusNumber: Int,
) {
    init {
        if (numbers.size != LOTTO_NUMBER_COUNT)
            throw WinningNumbersException.InvalidCount()
        if (bonusNumber in numbers)
            throw WinningNumbersException.BonusDuplicate()
    }

    fun match(lotto: Lotto): Int {
        return lotto.getNumbers().count { it in numbers }
    }

    fun isBonusMatch(lotto: Lotto): Boolean {
        return bonusNumber in lotto.getNumbers()
    }
}
