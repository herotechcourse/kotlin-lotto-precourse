package lotto

import lotto.view.InputView
import lotto.view.OutputView
import lotto.service.LottoManager

fun main() {
    // TODO: Implement the program
    val purchasedAmount = InputView.getPurchaseAmount();

    val ticketAmount = purchasedAmount / 1000

    val tickets = LottoManager.generateMultipleTickets(ticketAmount)

    val outputView = lotto.view.OutputView()
    outputView.displayPurchasedTicketsInfo(tickets)

    val winningNumbers = InputView.getWinningNumbers()
    val bonusNumber = InputView.getBonusNumber()

    
}
