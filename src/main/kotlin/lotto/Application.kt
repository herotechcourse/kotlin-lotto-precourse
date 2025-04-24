package lotto

fun main() {

    val inputView = InputView()
    val purchaseAmount = inputView.readPurchaseAmount()
    val amountOfTickets = purchaseAmount / LottoConstants.TICKET_PRICE
    Messages.display(Messages.TICKETS_PURCHASED, amountOfTickets)
}
