package lotto.domain

import lotto.Lotto

class LottoTicket(private val lotto: Lotto) {

    fun matchCount(winningNumbers: List<Int>): Int {
        return lotto.getNumbers().count { it in winningNumbers }
    }

    fun containsBonusNumber(bonusNumber: Int): Boolean {
        return lotto.getNumbers().contains(bonusNumber)
    }

    fun getNumbers(): List<Int> = lotto.getNumbers()
}
