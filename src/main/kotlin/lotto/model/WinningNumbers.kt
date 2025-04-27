package lotto.model

import lotto.exception.WinningNumbersException

class WinningNumbers(
    private val numbers: List<Int>,
    private val bonusNumber: Int,
) {
    init {
        require(numbers.size == 6) { throw WinningNumbersException.InvalidCount() }
        require(numbers.contains(bonusNumber).not()) { throw WinningNumbersException.BonusDuplicate() }
    }

    fun match(lotto: Lotto): Int {
        return lotto.getNumbers().count { it in numbers }
    }

    fun isBonusMatch(lotto: Lotto): Boolean {
        return bonusNumber in lotto.getNumbers()
    }
}
