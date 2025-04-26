package lotto

import lotto.view.InputView
import lotto.view.OutputView

object LottoResult {

    fun run() {
        val amount = InputView.readPurchaseAmount()
        val tickets = LottoGenerator.generate(amount)

        OutputView.printTicketCount(tickets.size)
        OutputView.printTickets(tickets)

        val winningNumbersInput = InputView.readWinningNumbers()
        val bonusNumberInput = InputView.readBonusNumber()

        val winningNumbers = WinningNumbers(winningNumbersInput, bonusNumberInput)


        val ranks = tickets.map { ticket ->
            val matchCount = winningNumbers.countMatch(ticket)
            val bonusMatched = winningNumbers.isBonusMatch(ticket)
            Rank.find(matchCount, bonusMatched)
        }

        val statistics = LottoStatistics(ranks)

        OutputView.printStatistics(statistics.getRankCounts())
        OutputView.printProfitRate(statistics.calculateProfitRate(amount))
    }
}
