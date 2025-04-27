package lotto

import lotto.utils.InputView.readBonusNumber
import lotto.utils.InputView.readPurchaseAmount
import lotto.utils.InputView.readWinningNumbers
import lotto.utils.OutputView.printPurchaseSummary
import lotto.utils.OutputView.printTicketsLn
import lotto.utils.OutputView.printWinningStatistics

fun main() {
    val game = initializeGame()
    setWinningNumbers(game)
    displayResults(game)
}

private fun initializeGame(): LottoGame {
    val purchaseAmount = readPurchaseAmount()
    val numberOfTickets = (purchaseAmount / 1000u).toInt()
    printPurchaseSummary(numberOfTickets)

    val game = LottoGame(purchaseAmount, numberOfTickets = numberOfTickets)
    printTicketsLn(game.getTickets())
    return game
}

private fun setWinningNumbers(game: LottoGame) {
    game.winningNumbers = readWinningNumbers()
    println()
    game.bonusNumber = readBonusNumber(game.winningNumbers)
    println()
}

private fun displayResults(game: LottoGame) {
    val results = game.getResults()
    val returnRate = game.getReturnRate()
    printWinningStatistics(results, returnRate)
}
