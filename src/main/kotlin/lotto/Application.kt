package lotto

import view.InputView
import view.OutputView

fun main() {
    val purchaseAmount = Money(InputView.readPurchaseAmount())
    val tickets = LottoGenerator.issue(purchaseAmount)
    println()
    OutputView.printIssuedTickets(tickets)
    println()
    val winningNumbers = InputView.readWinningNumbers()
    println()
    val bonusNumber = InputView.readBonusNumber(winningNumbers)
    println()
    OutputView.printStatistic(LottoGame(winningNumbers, bonusNumber, tickets).countWinningTickets(), purchaseAmount)
}
