package lotto

fun main() {

    val inputView = InputView()
    val purchaseAmount = inputView.readPurchaseAmount()
    val amountOfTickets = purchaseAmount / LottoConstant.TICKET_PRICE
    Message.display(Message.TICKETS_PURCHASED, amountOfTickets)
}
