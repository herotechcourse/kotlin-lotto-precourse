package lotto.model

import lotto.exception.WinningNumbersException

class WinningNumbers(
    private val numbers: List<Int>,
    private val bonusNumber: Int,
) {
    init {
        require(numbers.size == 6) { WinningNumbersException.INVALID_WINNING_NUMBERS.getMessage() }
        require(numbers.contains(bonusNumber).not()) { WinningNumbersException.BONUS_DUPLICATE.getMessage() }
    }

    fun match(lotto: Lotto): Int {
        return lotto.getNumbers().count { it in numbers }
    }

    fun isBonusMatch(lotto: Lotto): Boolean {
        return bonusNumber in lotto.getNumbers()
    }
}
