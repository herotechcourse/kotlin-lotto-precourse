package lotto.controller

import lotto.Lotto
import lotto.domain.LottoCalculator
import lotto.domain.TicketIssuer
import lotto.view.InputReader
import lotto.view.OutputPrinter
import java.lang.IllegalArgumentException

class LottoController(
    private val reader: InputReader,
    private val printer: OutputPrinter,
    private val issuer: TicketIssuer = TicketIssuer()
) {

    fun run(): Unit {
        // 1. Input purchase amount for buy the lottery tickets.
        val amount = reader.readPurchaseAmount()

        // 2. Print purchased lottery tickets with issued numbers (sorted)
        val ticketCount = amount.toInt() / Lotto.PRICE
        val tickets = issuer.issue(ticketCount)
        printer.printPurchasedTickets(tickets)

        // 3. Input last week's numbers
        val winningNumbers = RePrompter.retryPrompt({ reader.readWinningNumbers() })

        // 4. Input a bonus number.
        val bonusNumber = RePrompter.retryPrompt({ reader.readBonusNumber() })

        // 5. Print lotto result statistics and profit rate
        val result = LottoCalculator(
            winningNumbers = winningNumbers,
            bonusNumber = bonusNumber,
            tickets = tickets,
        )

        printer.printLottoResult(result.rankCount)
        printer.printProfitRate(result.profitRate)

        printer.close()
    }
}
