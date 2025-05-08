package lotto.controller

import lotto.Lotto
import lotto.domain.*
import lotto.view.InputReader
import lotto.view.OutputPrinter

class LottoController(
    private val reader: InputReader,
    private val printer: OutputPrinter,
    private val issuer: TicketIssuer = TicketIssuer()
) {

    fun run() {
        val validator = ApplicationValidator(reader, printer)
        val ticketCount = validator.extractOrThrow(reader.readPurchaseAmount(), PurchaseAmount::validate).countPurchasableTickets(Lotto.PRICE)
        val tickets = issuer.issue(ticketCount)
        printer.printPurchasedTickets(tickets)

        val winningNumbers = validator.extractOrRetry(reader::readWinningNumbers, WinningNumbers::validate)
        val bonusNumber = validator.extractOrRetry(reader::readBonusNumber, LottoNumber::validate)
        val result = LottoCalculator(winningNumbers, bonusNumber, tickets).getResult()
        printer.printLottoResult(result)
    }
}
