package lotto

import lotto.views.InputView
import lotto.views.OutputView

fun main() {
    // initializes input/output handlers and game logic
    val inputView = InputView()
    val outputView = OutputView()
    val lotteryGame = LotteryGame()

    // gets the purchase amount from the user
    val purchaseAmount = inputView.getPurchaseAmount()

    // generates lottery tickets based on the purchase amount
    val tickets = lotteryGame.generateAllTickets(purchaseAmount)

    // calculates how many tickets were purchased
    val ticketCount = lotteryGame.getTicketCount(purchaseAmount)

    // gets the winning numbers and bonus number from the user
    val winningNumbers = inputView.getWinningNumbers()
    val bonusNumber = inputView.getBonusNumber()

    // calculates the results: prize summary and return rate
    val (prizeSummary, returnRate) = lotteryGame.calculateLotteryResults(
        tickets, winningNumbers,bonusNumber, purchaseAmount
    )

    // displays the purchased tickets, prize summary, and return rate to the user
    outputView.printPurchasedTickets(tickets, ticketCount)
    outputView.printPrizeSummary(prizeSummary)
    outputView.printReturnRate(returnRate)
}
