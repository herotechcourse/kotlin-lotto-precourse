package lotto.domain

import lotto.Lotto

class WinningDraw(
    private val winningNumbers: Lotto,
    private val bonusNumber: Int
) {
    init {
        require(bonusNumber !in winningNumbers.getNumbers()) { "[ERROR] Bonus number must not be among winning numbers." }
    }

    fun match(ticket: Lotto): LottoRank? {
        val matchCount = ticket.matchCount(winningNumbers.getNumbers())
        val hasBonus = ticket.contains(bonusNumber)
        return LottoRank.find(matchCount, hasBonus)
    }
}