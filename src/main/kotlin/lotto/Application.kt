package lotto

import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()
    val ticketCount = purchaseAmount / 1000

    val machine = Machine()
    val tickets = machine.generateTickets(ticketCount)

    OutputView.printTickets(tickets)

    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber()

    val winning = WinningNumbers(winningNumbers, bonusNumber)
    val result = Result(tickets, winning)

    OutputView.printResult(result, purchaseAmount)
}