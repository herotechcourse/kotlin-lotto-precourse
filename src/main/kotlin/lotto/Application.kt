package lotto

import lotto.views.InputView
import lotto.views.OutputView

fun main() {
    val amount = InputView.readPurchaseAmount()
    val tickets = LottoMachine.generateTickets(amount)
    OutputView.printTickets(tickets)
    val winningNumbers = InputView.readWinningNumbers()
    println("Winning numbers: $winningNumbers") // Temp debug
}