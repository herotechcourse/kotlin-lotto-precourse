package lotto

import lotto.LottoConstants.LOTTO_NUMBER_COUNT
import lotto.LottoConstants.LOTTO_NUMBER_MAX
import lotto.LottoConstants.LOTTO_NUMBER_MIN

data class PickedNumbers(
    val winningNumbers: List<Int>,
    val bonusNumber: Int,
) {
    init {
        require(winningNumbers.size == LOTTO_NUMBER_COUNT) { "[ERROR] Winning numbers must contain exactly 6 numbers." }
        require(winningNumbers.toSet().size == LOTTO_NUMBER_COUNT) { "[ERROR] Winning numbers must not contain duplicates." }
        require(winningNumbers.all { it in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX }) { "[ERROR] Winning numbers must be between 1 and 45." }
        require(bonusNumber in LOTTO_NUMBER_MIN..LOTTO_NUMBER_MAX) { "[ERROR] Bonus number must be between 1 and 45." }
        require(bonusNumber !in winningNumbers) { "[ERROR] Bonus number must not overlap with winning numbers." }
    }

    fun matchCountOf(lotto: Lotto): Int {
        return lotto.getNumbers().count { it in winningNumbers }
    }

    fun hasBonusNumber(lotto: Lotto): Boolean {
        return bonusNumber in lotto.getNumbers()
    }
}
