package lotto

fun main() {
    try {

        val inputView = InputView()
        val outputView = OutputView()

        val tickets = inputView.readPurchaseAmount()
        outputView.printPurchasedTickets(tickets)
        val winningNumbers = inputView.getWinningNumbers()
        val bonusNumber = inputView.getBonusNumber()

        outputView.printResult(tickets, winningNumbers, bonusNumber)

    } catch (e: IllegalArgumentException) {
        println(e.message)
        main()
    }
}