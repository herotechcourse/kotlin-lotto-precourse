package lotto

import lotto.utils.InputView.readBonusNumber
import lotto.utils.InputView.readPurchaseAmount
import lotto.utils.InputView.readWinningNumbers
import lotto.utils.OutputView.printTicketsLn
import lotto.utils.OutputView.printWinningStatistics

// TODO: refactor into separate functions
fun main() {
    val purchaseAmount = readPurchaseAmount()
    val numberOfTickets = (purchaseAmount / 1000u).toInt()
    println("\nYou have purchased $numberOfTickets tickets.")

    val game = LottoGame(purchaseAmount, numberOfTickets = numberOfTickets)
    printTicketsLn(game.getTickets())

    game.winningNumbers = readWinningNumbers()
    println()
    game.bonusNumber = readBonusNumber(game.winningNumbers)
    println()

    val results = game.getResults()
    val returnRate = game.getReturnRate()
    printWinningStatistics(results, returnRate)
}
