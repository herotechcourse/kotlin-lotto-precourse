package lotto

import lotto.view.InputParamsReader
import lotto.view.OutputView

class LotteryRunner {
    private val reader = InputParamsReader()
    private val ticketsGenerator = LottoTicketsGenerator()

    fun run() {
        val amount = reader.retrievePurchaseAmountWithRetry()
        val tickets = ticketsGenerator.generateTickets(amount)
        OutputView.printTickets(tickets)

        val winningNumbers = reader.retrieveLastWeekWinningNumbersWithRetry()
        val bonusNumber = reader.retrieveBonusNumberWithRetry(winningNumbers)

        val ranks = tickets.map { ticket ->
            val matchCount = ticket.matchCount(winningNumbers)
            val bonusMatched = ticket.contains(bonusNumber)
            Rank.of(matchCount, bonusMatched)
        }

        val result = LottoResult(ranks)
        OutputView.printStatistics(result, amount)
    }
}