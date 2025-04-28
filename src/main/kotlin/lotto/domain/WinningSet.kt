package lotto.domain

import lotto.Lotto
import lotto.view.InputView
import lotto.domain.Rank

class WinningSet {
    private val winningNumbers: Lotto = InputView.getWinningNumbers()
    private val bonusNumber: Int = InputView.getBonusNumber(winningNumbers)

    fun match(ticket: Lotto): Rank? {
        val matchCount = ticket.matchCount(winningNumbers.getNumbers())
        val hasBonus = ticket.contains(bonusNumber)
        return Rank.find(matchCount, hasBonus)
    }
}