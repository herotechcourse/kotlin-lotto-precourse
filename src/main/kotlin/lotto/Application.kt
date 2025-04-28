package lotto

import lotto.factory.InputViewFactory
import lotto.view.input.BonusNumberInputView
import lotto.view.input.WinningNumbersInputView

fun main() {
    // TODO: Implement the program
    val inputView = InputViewFactory.getInputView()
    val purchaseAmount = PurchaseAmount(inputView.readInput())
    println("PurchaseAmount: ${purchaseAmount}")
    val ticketCounts = purchaseAmount.getTicketCount()
    println("TicketCounts: ${ticketCounts}")

    var tickets = mutableListOf<Lotto>()
    val lottos = Lottos(tickets, ticketCounts)

    for (lotto in lottos.getTickets()) {
        println("Lotto: ${lotto.getNumbers()}")
    }

    val winningNumbers = WinningNumbersInputView.readInput().split(",")
    val bonusNumber = BonusNumberInputView.readInput()
    val allNumbers = WinningNumbers(winningNumbers, bonusNumber)
    println("WinningNumbers: ${allNumbers.getWinningNumbers()}")
    println("BonusNumber: ${allNumbers.getBonusNumber()}")
}

