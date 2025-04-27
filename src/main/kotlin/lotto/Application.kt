package lotto


fun main() {

    val inputView = InputView()
    val ticketNumber = inputView.readPurchase()
    val lottoWinningNumbers = inputView.promptWinningNumbers()

    val lottoTickets = LottoTicketGeneration.generateTicket(ticketNumber)

    val outputView = OutputView(lottoTickets, lottoWinningNumbers)
    outputView.printOutput()
}
