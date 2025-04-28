package lotto

import lotto.factory.InputViewFactory
import lotto.view.input.BonusNumberInputView
import lotto.view.input.WinningNumbersInputView
import lotto.enums.InputType
import lotto.view.output.DisplayLottosOutputView

fun main() {
    // TODO: Implement the program
    val purchaseView   = InputViewFactory.createInputView(InputType.PURCHASE_AMOUNT)
    val purchaseAmount = PurchaseAmount(purchaseView.readInput())
    println("PurchaseAmount: $purchaseAmount")

    val ticketCounts = purchaseAmount.getTicketCount()
    println("TicketCounts: $ticketCounts")
    val lottos = Lottos(mutableListOf(), ticketCounts)

    DisplayLottosOutputView.display(lottos)

    val winningNumbers = WinningNumbersInputView.readInput().split(",")
    val bonusNumber = BonusNumberInputView.readInput()
    val allNumbers = WinningNumbers(winningNumbers, bonusNumber)
    println("WinningNumbers: ${allNumbers.getWinningNumbers()}")
    println("BonusNumber: ${allNumbers.getBonusNumber()}")
}

