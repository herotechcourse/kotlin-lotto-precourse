package lotto

import lotto.domain.Rank
import lotto.view.InputView
import lotto.service.LottoMachine
import lotto.service.Statistics
import lotto.view.OutputView

fun main() {

    val purchaseAmount = InputView.readPurchaseAmount()
    val machine = LottoMachine()
    val tickets = machine.purchaseTickets(purchaseAmount)

    OutputView.printTickets(tickets.map { it.getNumbers() })

    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber(winningNumbers)

    val ranks = tickets.map { ticket ->
        val numbers = ticket.getNumbers()
        val matchCount = numbers.count { it in winningNumbers }
        val hasBonus = numbers.contains(bonusNumber)
        Rank.from(matchCount, hasBonus)
    }

    val statistics = Statistics.from(ranks, purchaseAmount)
    OutputView.printStatistics(statistics)
}
