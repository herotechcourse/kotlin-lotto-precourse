// src/main/kotlin/lotto/Application.kt
package lotto

import lotto.view.InputView
import lotto.service.LottoService
import lotto.view.OutputView

fun readPurchaseAmount(): Int = InputView.readPurchaseAmount()

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()
    val tickets = LottoService.generateTickets(purchaseAmount)
    val ticketNumbers = tickets.map { it.numbers() }
    OutputView.printTickets(ticketNumbers)

    val winningNumbers = InputView.readWinningNumbers()
    val stats = LottoService.calculateStatistics(tickets, winningNumbers)
    OutputView.printStatistics(stats, purchaseAmount)
}
