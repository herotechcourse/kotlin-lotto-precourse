package lotto

import lotto.views.InputView
import lotto.views.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val machine = TicketMachine()
    val evaluator = LottoResultEvaluator()

    val purchaseAmount = runUntilValid { inputView.readPurchaseAmount() }
    val tickets        = machine.generateTickets(purchaseAmount)
    outputView.printTickets(tickets)

    val winningNumbers = runUntilValid { inputView.readWinningNumbers() }
    val bonusNumber    = runUntilValid { inputView.readBonusNumber(winningNumbers) }

    val results    = evaluator.evaluate(tickets, winningNumbers, bonusNumber)
    val profitRate = evaluator.calculateProfitRate(tickets, results)
    outputView.printResultStatistics(results, profitRate)
}

private inline fun <T> runUntilValid(block: () -> T): T {
    while (true) {
        try {
            return block()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}
