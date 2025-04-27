package lotto

import lotto.view.InputView
import lotto.view.OutputView

object LottoResult {

    fun run() {
        val amount = readAmount()
        val tickets = generateTickets(amount)

        OutputView.printTicketCount(tickets.size)
        OutputView.printTickets(tickets)

        val winningNumbers = readWinningNumbers()

        val ranks = matchTickets(tickets, winningNumbers)
        val statistics = LottoStatistics(ranks)

        OutputView.printStatistics(statistics.getRankCounts())
        OutputView.printProfitRate(statistics.calculateProfitRate(amount))
    }

    private fun readAmount(): Int {
        return InputView.readPurchaseAmount()
    }

    private fun generateTickets(amount: Int): List<Lotto> {
        return LottoGenerator.generate(amount)
    }

    private fun readWinningNumbers(): WinningNumbers {
        return retryInput {
            val winningNumbersInput = InputView.readWinningNumbers()
            val bonusNumberInput = InputView.readBonusNumber()
            WinningNumbers(winningNumbersInput, bonusNumberInput)
        }
    }

    private fun matchTickets(tickets: List<Lotto>, winningNumbers: WinningNumbers): List<Rank> {
        return tickets.map { ticket ->
            val matchCount = winningNumbers.countMatch(ticket)
            val bonusMatched = winningNumbers.isBonusMatch(ticket)
            Rank.find(matchCount, bonusMatched)
        }
    }

    private fun <T> retryInput(action: () -> T): T {
        return try {
            action()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            retryInput(action)
        }
    }
}
