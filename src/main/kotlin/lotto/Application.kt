package lotto

import lotto.views.InputView
import lotto.views.OutputView

fun main() {
    val amount = InputView.readPurchaseAmount()
    val tickets = LottoGenerator.generateTicket(amount)
    OutputView.printTickets(tickets)

    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber(winningNumbers)

    val winningLotto = WinningLotto(winningNumbers, bonusNumber)

    val ranks = tickets.map { ticket ->
        val matchCount = winningLotto.matchCount(ticket)
        val bonusMatched = winningLotto.isBonusMatched(ticket)
        Ranks.of(matchCount, bonusMatched)
    }

}