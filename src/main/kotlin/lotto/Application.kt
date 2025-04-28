package lotto

import lotto.domain.LottoGame
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()
    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber    = InputView.readBonusNumber(winningNumbers)

    val game = LottoGame(purchaseAmount, winningNumbers, bonusNumber)

    val tickets = game.createTickets()
    OutputView.printTickets(tickets)

    val stats = game.calculateResults()
    OutputView.printStatistics(stats)
}
