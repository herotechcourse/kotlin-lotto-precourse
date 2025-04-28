package lotto

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()
    val lottoMachine = LottoMachine()
    val tickets = lottoMachine.generateTickets(purchaseAmount)

    println("You have purchased ${tickets.size} tickets.")
    tickets.forEach { println(it.getNumbers()) } // TEMP: will later move to OutputView
}
