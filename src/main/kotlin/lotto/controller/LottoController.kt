package lotto.controller

import lotto.Lotto
import lotto.domain.LottoCalculator
import lotto.domain.TicketIssuer
import lotto.view.InputReader
import lotto.view.OutputPrinter

class LottoController(
    private val reader: InputReader,
    private val printer: OutputPrinter,
    private val issuer: TicketIssuer = TicketIssuer()
) {

    fun run() {
        val ticketCount = reader.readPurchaseAmount().countPurchasableTickets(Lotto.PRICE)
        val tickets = issuer.issue(ticketCount)
        printer.printPurchasedTickets(tickets)

        val winningNumbers = RePrompter.retryPrompt({ reader.readWinningNumbers() })
        val bonusNumber = RePrompter.retryPrompt({ reader.readBonusNumber() })
        val result = LottoCalculator(winningNumbers, bonusNumber, tickets).getResult()
        printer.printLottoResult(result)

        printer.close()
    }
}
