package lotto

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()
    val lottoMachine = LottoMachine()
    val tickets = lottoMachine.generateTickets(purchaseAmount)

    OutputView.printPurchasedTickets(tickets)
}
