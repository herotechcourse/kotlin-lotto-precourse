package lotto

fun main() {
    try {
        val inputView = InputView()
        val outputView = OutputView()

        val amount = inputView.readPurchaseAmount()
        val purchase = Purchase(amount)
        outputView.displayTickets(purchase.tickets)

        val winningNumbers = inputView.readWinningNumbers()
        val lotto = Lotto(winningNumbers)
        val bonusNumber = inputView.readBonusNumber()
        lotto.addBonusNumber(bonusNumber)
        val result = lotto.compareNumbers(purchase.tickets)
        outputView.printStatistics(result)
    } catch (e: InputView.MaxRetryException) {
        println(e.message + " Exiting...")
        return
    }
}
