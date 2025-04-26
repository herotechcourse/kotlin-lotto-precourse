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
        try {
            val purchaseAmount = getPurchaseAmount()
            val tickets = lottoService.createLottoTickets(purchaseAmount)
            outputView.printPurchasedTickets(tickets)
            val winningNumbers = getWinningNumbers()
            val bonusNumber = getBonusNumber(winningNumbers)
            val winningLotto = Lotto(winningNumbers)
            val rankCounts = lottoService.determineRankCounts(tickets, winningLotto, bonusNumber)
            outputView.printWinningStatistics(rankCounts, purchaseAmount)
        } catch (e: IllegalArgumentException) {
            println(e.message)
            run()
        }
    }

    private fun getPurchaseAmount(): Int {
        return inputView.readPurchaseAmount()
    }

    private fun getWinningNumbers(): List<Int> {
        return inputView.readWinningNumbers()
    }

    private fun getBonusNumber(winningNumbers: List<Int>): Int {
        return inputView.readBonusNumber(winningNumbers)
    }
}
