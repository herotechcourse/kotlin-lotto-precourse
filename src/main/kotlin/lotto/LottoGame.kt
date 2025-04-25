package lotto

class LottoGame {
    fun run(){
        val amount = InputView.readPurchaseAmount()
        val ticketCount = amount / 1000
        OutputView.printTicketCount(ticketCount)

        val tickets = LottoMachine.generateTickets(ticketCount)
        OutputView.printTickets(tickets)
    }
}