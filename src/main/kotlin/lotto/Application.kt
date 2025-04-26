package lotto

fun main() {
    val application = LottoApplication()
    application.run()
}

class LottoApplication {
    private val inputView = InputView()
    private val outputView = OutputView()
    private val lottoService = LottoService()

    fun run() {
        val purchaseAmount = withRetry { inputView.readPurchaseAmount() }
        val tickets = lottoService.createLottoTickets(purchaseAmount)
        outputView.printPurchasedTickets(tickets)
        
        val winningNumbers = withRetry { inputView.readWinningNumbers() }
        val bonusNumber = withRetry { inputView.readBonusNumber(winningNumbers) }
        
        val winningLotto = Lotto(winningNumbers)
        val rankCounts = lottoService.determineRankCounts(tickets, winningLotto, bonusNumber)
        outputView.printWinningStatistics(rankCounts, purchaseAmount)
    }

    private fun <T> withRetry(action: () -> T): T {
        while (true) {
            try {
                return action()
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }
}
