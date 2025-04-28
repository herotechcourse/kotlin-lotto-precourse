package lotto

import lotto.domain.WinningNumbers
import lotto.service.LottoService
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()
    val tickets = LottoService.generateTickets(purchaseAmount)
    OutputView.printTickets(tickets.map { it.numbers() })

    val winningNumbers = InputView.readWinningNumbers()
    val stats = LottoService.calculateStatistics(tickets, winningNumbers)
    OutputView.printStatistics(stats, purchaseAmount)
}
