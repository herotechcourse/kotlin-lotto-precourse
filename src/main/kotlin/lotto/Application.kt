package lotto

fun main() {
    Application().run()
}

class Application {
    fun run() {
        try {
            val purchaseAmount = InputView.readPurchaseAmount()
            val tickets = LottoMachine.buyTickets(purchaseAmount)
            OutputView.printTickets(tickets)

            val winningNumbers = InputView.readWinningNumbers()
            val bonusNumber = InputView.readBonusNumber()

            val winningLotto = WinningLotto(winningNumbers, bonusNumber)

            val result = LottoResult(tickets, winningLotto)
            OutputView.printResult(result)

        } catch (e: IllegalArgumentException) {
            println("[ERROR] ${e.message}")
        }
    }
}
