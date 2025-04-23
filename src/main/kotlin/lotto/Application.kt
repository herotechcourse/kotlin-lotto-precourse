package lotto

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val purchaseAmount = inputView.readValidPurchaseAmount()
//    val purchaseAmount = 4000

    val numberOfTickets = LottoMachine.getTicketCount(purchaseAmount)
    val tickets = LottoMachine.generateTickets(numberOfTickets)
    outputView.printTickets(tickets)

    val winningNumbers = inputView.readValidWinningNumbers()
    val bonusNumber = inputView.readValidBonusNumber()


//    val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
//    val bonusNumber = 21
}
