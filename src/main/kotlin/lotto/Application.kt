package lotto

fun main() {
    val amount = InputView.readPurchaseAmount()
    val ticketCount = amount / 1000
    val tickets = LottoService.generateTickets(ticketCount)

    OutputView.printTickets(tickets)
}
