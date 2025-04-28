package lotto

import lotto.views.InputView
import lotto.views.OutputView

fun main() {
    val inputView = InputView()
    val game = LotteryGame()
    val outputView = OutputView()

    val purchaseAmount = inputView.getPurchaseAmount()
    val tickets = game.generateAllTickets(purchaseAmount)
    val ticketCount = game.getTicketCount(purchaseAmount)

    val winningNumbers = inputView.getWinningNumbers()
    val bonusNumber = inputView.getBonusNumber()

    val (winningStatuses, returnRate) = game.getLotteryResults(tickets, winningNumbers,bonusNumber, purchaseAmount)

    outputView.printPurchasedTickets(tickets, ticketCount)
    outputView.printWinningStatuses(winningStatuses)
    outputView.printReturnRate(returnRate)
}



