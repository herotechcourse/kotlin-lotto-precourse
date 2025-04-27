package lotto

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val lottoMachine = LottoMachine()

    val purchaseAmount = getValidPurchaseAmount(inputView)
    val tickets = lottoMachine.generateTickets(purchaseAmount)
    outputView.printTickets(tickets)

    val winningNumbers = getValidWinningNumbers(inputView)
    val bonusNumber = getValidBonusNumber(inputView, winningNumbers)

    val results = lottoMachine.calculateResults(tickets, winningNumbers, bonusNumber)
    val returnRate = lottoMachine.calculateReturnRate(results, purchaseAmount)
    outputView.printStatistics(results, returnRate)
}

private fun getValidPurchaseAmount(inputView: InputView): Int {
    while (true) {
        try {
            return inputView.readPurchaseAmount()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

private fun getValidWinningNumbers(inputView: InputView): List<Int> {
    while (true) {
        try {
            return inputView.readWinningNumbers()
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}

private fun getValidBonusNumber(inputView: InputView, winningNumbers: List<Int>): Int {
    while (true) {
        try {
            return inputView.readBonusNumber(winningNumbers)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
}