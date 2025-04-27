package lotto

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val lottoMachine = LottoMachine()

    try {
        // 1. Get purchase amount and generate tickets
        val purchaseAmount = inputView.readPurchaseAmount()
        val tickets = lottoMachine.generateTickets(purchaseAmount)
        outputView.printTickets(tickets)

        // 2. Get winning numbers and bonus number
        val winningNumbers = inputView.readWinningNumbers()
        val bonusNumber = inputView.readBonusNumber(winningNumbers)

        // 3. Calculate and display results
        val results = lottoMachine.calculateResults(tickets, winningNumbers, bonusNumber)
        val returnRate = lottoMachine.calculateReturnRate(results, purchaseAmount)
        outputView.printStatistics(results, returnRate)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}