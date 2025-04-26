package lotto

import view.Input
import view.Output

fun main() {
    Output.printPurchaseAmountInputMessage()
    val purchaseAmount = Input.readPurchaseAmountSafely() ?: return

    val tickets = List(purchaseAmount / 1000) { Lotto.create() }
    Output.printPurchasedTicketsMessage(tickets)

    Output.printLastWeeksWinningNumbersInputMessage()
    val winningNumbers = Input.readWinningNumbersSafely() ?: return

    Output.printBonusNumberInputMessage()
    val bonusNumber = Input.readBonusNumberSafely(winningNumbers) ?: return

    val ranks = tickets.map { it.toRank(winningNumbers, bonusNumber) }
    val statistic = Statistic(ranks)
    Output.printWinningStatisticsMessage(statistic)
}
