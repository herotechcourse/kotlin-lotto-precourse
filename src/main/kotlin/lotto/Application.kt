package lotto

import lotto.view.InputView
import lotto.service.LottoService
import lotto.view.OutputView

fun main() {
    try {
        val purchaseAmount = InputView.purchaseAmount()
        val tickets = LottoService.generateTickets(purchaseAmount)
        OutputView.printTickets(tickets)

        val winningNumbers = InputView.inputWinningsNumbers()
        val bonusNumber = InputView.inputBonusNumber(winningNumbers)

        val lottoService = LottoService(winningNumbers, bonusNumber)

        val ranks = tickets.map { lottoService.verifyTicket(it) }

        val returnRate = lottoService.getReturnRate(ranks, purchaseAmount)

        val ranksCount = lottoService.countRanks(ranks)

        OutputView.printStatistics(ranksCount, returnRate)

    } catch (ex: IllegalArgumentException) {
        println(ex.message)
    }
}
