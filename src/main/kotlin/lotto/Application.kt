package lotto

fun main() {
    val purchaseAmount = InputHandler.readAndValidatePurchaseAmount()
    val lottoMachine = LottoMachine(purchaseAmount)
    val ticketCount = lottoMachine.calculateTicketCount()
    val tickets = lottoMachine.generateTickets(ticketCount)
    println(tickets)
    //TODO the objects are returned. let's implement a getter for them


}
