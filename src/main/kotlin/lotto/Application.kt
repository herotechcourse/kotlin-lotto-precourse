package lotto

import lotto.util.LottoTicketGeneration
import lotto.view.InputView
import lotto.view.OutputView


fun main() {

    // Input data
    val inputView = InputView()
    val ticketNumber = inputView.readPurchase()

    // Generate tickets
    val lottoTickets = LottoTicketGeneration.generateTicket(ticketNumber)
    LottoTicketGeneration.printLottoTickets(lottoTickets)

    //Show last week winning numbers
    val lottoWinningNumbers = inputView.readWinningNumbers()

    // Show the statistics
    val outputView = OutputView(lottoTickets, lottoWinningNumbers)

    outputView.printStatistics()
}
