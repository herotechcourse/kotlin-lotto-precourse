package lotto

import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val userInput = UserInput()
    val ticketPurchase = TicketPurchase()

    var isInputValid = false
    while (!isInputValid) {
        try {
            InputView.promptPurchaseAmount(userInput)
            isInputValid = true
        } catch (e: Exception) {
            println(e.message)
        }
    }

    ticketPurchase.buyTickets(userInput)
    ticketPurchase.generateTickets()
    OutputView.displayPurchaseMessage(ticketPurchase)
    OutputView.displayBoughtTickets(ticketPurchase)

    isInputValid = false
    while (!isInputValid) {
        try {
            InputView.promptWinningNumbers(userInput)
            isInputValid = true
        } catch (e: Exception) {
            println(e.message)
        }
    }

    isInputValid = false
    while (!isInputValid) {
        try {
            InputView.promptBonusNumber(userInput)
            isInputValid = true
        } catch (e: Exception) {
            println(e.message)
        }
    }

    val lottoResult = LottoResult()
    OutputView.displayWinningStatistics(lottoResult)
    OutputView.displayReturnRate(lottoResult)
}

