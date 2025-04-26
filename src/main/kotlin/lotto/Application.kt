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
        val purchaseAmount = getPurchaseAmount()
        val tickets = purchaseTickets(purchaseAmount)
        val (winningLotto, bonusNumber) = getWinningInfo()
        val results = determineResults(tickets, winningLotto, bonusNumber)
        displayStatistics(results, purchaseAmount)
    }

    private fun getPurchaseAmount(): Int {
        return withRetry { inputView.readPurchaseAmount() }
    }

    private fun purchaseTickets(amount: Int): List<Lotto> {
        val tickets = lottoService.createLottoTickets(amount)
        outputView.printPurchasedTickets(tickets)
        return tickets
    }

    private fun getWinningInfo(): Pair<Lotto, Int> {
        val winningNumbers = withRetry { inputView.readWinningNumbers() }
        val bonusNumber = withRetry { inputView.readBonusNumber(winningNumbers) }
        return Pair(Lotto(winningNumbers), bonusNumber)
    }

    private fun determineResults(tickets: List<Lotto>, winningLotto: Lotto, bonusNumber: Int): Map<Rank, Int> {
        return lottoService.determineRankCounts(tickets, winningLotto, bonusNumber)
    }

    private fun displayStatistics(results: Map<Rank, Int>, purchaseAmount: Int) {
        outputView.printWinningStatistics(results, purchaseAmount)
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