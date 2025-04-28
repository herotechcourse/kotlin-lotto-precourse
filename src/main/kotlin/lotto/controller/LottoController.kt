package lotto.controller

import lotto.Lotto
import lotto.domain.LottoTicketGeneration
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    fun run() {

        // Input data
        val inputView = InputView()
        val amountMoney = inputView.readPurchase()

        // Generate tickets
        val ticketNumber = amountMoney / Lotto.PRICE_TICKET
        val lottoTickets = LottoTicketGeneration.generateTickets(ticketNumber)
        LottoTicketGeneration.printLottoTickets(lottoTickets)

        //Show last week winning numbers
        val lottoWinningNumbers = inputView.readWinningNumbers()

        // Show the statistics
        val outputView = OutputView(lottoTickets, lottoWinningNumbers)

        outputView.printStatistics()
    }
}