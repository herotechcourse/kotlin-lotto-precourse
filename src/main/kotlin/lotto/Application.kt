package lotto

import lotto.views.InputView
import lotto.views.OutputView

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val lotteryGame = LotteryGame()

    val purchaseAmount = inputView.getPurchaseAmount()
    val tickets = lotteryGame.generateAllTickets(purchaseAmount)
    val ticketCount = lotteryGame.getTicketCount(purchaseAmount)

    val winningNumbers = inputView.getWinningNumbers()
    val bonusNumber = inputView.getBonusNumber()

    val (prizeSummary, returnRate) = lotteryGame.getLotteryResults(tickets, winningNumbers,bonusNumber, purchaseAmount)

    outputView.printPurchasedTickets(tickets, ticketCount)
    outputView.printPrizeSummary(prizeSummary)
    outputView.printReturnRate(returnRate)
}



