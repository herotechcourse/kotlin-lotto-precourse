package lotto

import lotto.domain.LottoMachine
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    try {
        val amount = InputView.getPurchaseAmount()
        val tickets = LottoMachine.generateTickets(amount)
        OutputView.printTickets(tickets)

        val winningNumbers = InputView.getWinningNumbers()
        val bonusNumber = InputView.getBonusNumber(winningNumbers)

        val result = LottoMachine.calculateResults(tickets, winningNumbers, bonusNumber)
        OutputView.printStatistics(result, amount)
    } catch (e: IllegalArgumentException) {
        println("[ERROR] ${e.message}")
    }
}