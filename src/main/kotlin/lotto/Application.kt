package lotto

import lotto.views.InputView
import lotto.views.OutputView

fun main() {
    val inputView = InputView()
    val game = LotteryGame()
    val outputView = OutputView()
    val lotteryResults = LotteryResults()

    val purchaseAmount = inputView.getPurchaseAmount()
    val tickets = game.generateAllTickets(purchaseAmount)
    val ticketCount = game.getTicketCount(purchaseAmount)


    val winningNumbers = inputView.getWinningNumbers()
    val bonusNumber = inputView.getBonusNumber()

    val winningStatuses = lotteryResults.getStatistics(tickets, winningNumbers, bonusNumber)

    val returnRate = lotteryResults.calculateReturnRate(purchaseAmount)


    outputView.printPurchasedTickets(tickets, ticketCount)
    outputView.printWinningStatuses(winningStatuses)
    outputView.printReturnRate(returnRate)
}



