package lotto

import lotto.domain.Rank
import lotto.view.InputView
import lotto.service.TicketMachine
import lotto.service.Statistics
import lotto.util.Config
import lotto.view.OutputView

class LottoController(
    private val machine: TicketMachine = TicketMachine()

) {
    fun run() {
        println("***** Welcome to Lotto *****")
        println()
        println("Each ticket costs ${Config.TICKET_PRICE} KRW.")
        println()

        val purchaseAmount = InputView.readPurchaseAmount()
        val tickets = machine.generateTickets(purchaseAmount)

        OutputView.printTickets(tickets.map { it.getNumbers() })

        val winningNumbers = InputView.readWinningNumbers()
        val bonusNumber = InputView.readBonusNumber(winningNumbers)

        val ranks = tickets.map { ticket ->
            val nums = ticket.getNumbers()
            Rank.from(nums.count { it in winningNumbers }, nums.contains(bonusNumber))
        }

        val stats = Statistics.from(ranks, purchaseAmount)
        OutputView.printStatistics(stats)
    }
}
