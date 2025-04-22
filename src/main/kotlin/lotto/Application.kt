package lotto

import lotto.views.InputView
import lotto.views.OutputView

fun main() {
    val amount = InputView.readPurchaseAmount()
    val tickets = LottoMachine.generateTickets(amount)
    OutputView.printTickets(tickets)

    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber(winningNumbers)

    val ranks = tickets.map { ticket ->
        val matchCount = ticket.matchCount(winningNumbers)
        val bonusMatched = ticket.contains(bonusNumber)
        Rank.of(matchCount, bonusMatched)
    }
    val result = LottoResult(ranks)

    //Temporal debug print statements
    println(result.getRankCounts())
    println("Total Prize: ${result.totalPrize()}")
}