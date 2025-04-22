package lotto

import lotto.views.InputView
import lotto.views.OutputView

fun main() {
    val amount = InputView.readPurchaseAmount()
    val tickets = LottoMachine.generateTickets(amount)
    OutputView.printTickets(tickets)

    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber(winningNumbers)
    println("Bonus number: $bonusNumber") // Temp debug
}