package lotto

fun main() {
    val purchaseAmount = InputHandler.readAndValidatePurchaseAmount()
    val lottoMachine = LottoMachine(purchaseAmount)
    val ticketCount = lottoMachine.calculateTicketCount()
    val tickets = lottoMachine.generateTickets(ticketCount)
    tickets.forEach { println(it.getNumbers()) }


}
