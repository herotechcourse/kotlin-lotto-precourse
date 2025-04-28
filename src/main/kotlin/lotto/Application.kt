package lotto

import lotto.domain.LottoGame
import lotto.ui.InputView
import lotto.ui.OutputView

fun main() {
    val lottoGame = LottoGame()
    try {
        // Get purchase amount and generate tickets
        val purchaseAmount = InputView.readPurchaseAmount()
        val tickets = lottoGame.generateTickets(purchaseAmount)
        OutputView.printTickets(tickets)

        // Get winning numbers and bonus number
        val winningNumbers = InputView.readWinningNumbers()
        val bonusNumber = InputView.readBonusNumber(winningNumbers)

        // Calculate and display results
        val results = lottoGame.calculateResults(tickets, winningNumbers, bonusNumber)
        OutputView.printResults(results)

        // Calculate and display profit rate
        val profitRate = lottoGame.calculateProfitRate(purchaseAmount, results)
        OutputView.printProfitRate(profitRate)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
