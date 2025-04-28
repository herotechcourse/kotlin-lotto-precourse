package lotto

import lotto.view.InputView
import lotto.view.OutputView

class LottoGame {
    companion object {
        fun run() {
            val amount = InputView.readPurchaseAmount()
            val tickets = LottoMachine.generateTickets(amount)
            OutputView.printTickets(tickets)

            val winningNumbers = InputView.readWinningNumbers()
            val bonusNumber = InputView.readBonusNumber(winningNumbers)

            val ranks = tickets.map { ticket ->
                val matchCount = ticket.matchCount(winningNumbers)
                val bonusMatched = ticket.contains(bonusNumber)
                Rank.of(matchCount, bonusMatched)
            }

            val result = LottoResult(ranks)
            OutputView.printStatistics(result, amount)
        }
    }
}
