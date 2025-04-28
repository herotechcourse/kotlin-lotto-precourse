package lotto

import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val userInput = UserInput()
    val ticketPurchase = TicketPurchase()
    val lottoResult = LottoResult()
    runLotto(userInput, ticketPurchase, lottoResult)
}

fun runLotto(userInput: UserInput, ticketPurchase: TicketPurchase, lottoResult: LottoResult) {
    promptPurchaseAmount(userInput)
    ticketPurchase.buyTickets(userInput)
    ticketPurchase.generateTickets()
    displayTicketPurchase(ticketPurchase)
    promptWinningNumbers(userInput)
    promptBonusNumber(userInput)
    generateLottoResults(userInput, ticketPurchase, lottoResult)
    displayLottoResults(lottoResult)
}

fun promptPurchaseAmount(userInput: UserInput) {
    var isInputValid = false
    while (!isInputValid) {
        try {
            InputView.promptPurchaseAmount(userInput)
            isInputValid = true
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun displayTicketPurchase(ticketPurchase: TicketPurchase) {
    OutputView.displayPurchaseMessage(ticketPurchase)
    OutputView.displayBoughtTickets(ticketPurchase)
}

fun promptWinningNumbers(userInput: UserInput) {
    var isInputValid = false
    while (!isInputValid) {
        try {
            InputView.promptWinningNumbers(userInput)
            isInputValid = true
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun promptBonusNumber(userInput: UserInput) {
    var isInputValid = false
    while (!isInputValid) {
        try {
            InputView.promptBonusNumber(userInput)
            isInputValid = true
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

fun generateLottoResults(userInput: UserInput, ticketPurchase: TicketPurchase, lottoResult: LottoResult) {
    lottoResult.generateWinningStatistics(userInput, ticketPurchase)
    lottoResult.calculateReturnRate(userInput)
}

fun displayLottoResults(lottoResult: LottoResult) {
    OutputView.displayWinningStatistics(lottoResult)
    OutputView.displayReturnRate(lottoResult)
}