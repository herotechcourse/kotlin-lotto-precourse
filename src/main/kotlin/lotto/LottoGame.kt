package lotto

class LottoGame(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {

    fun play() {
        val purchase = purchaseTickets()
        outputView.displayTickets(purchase.tickets)

        val lotto = inputWinningNumbers()
        inputBonusNumber(lotto)

        evaluateResults(lotto, purchase)
    }

    private fun purchaseTickets(): Purchase {
        repeat(MAX_RETRY) {
            try {
                val amount = inputView.readPurchaseAmount()
                val purchase = Purchase(amount)
                return purchase
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        throw MaxRetryException(MAX_RETRY_MSG)
    }

    private fun inputWinningNumbers(): Lotto {
        repeat(MAX_RETRY) {
            try {
                val winningNumbers = inputView.readWinningNumbers()
                val lotto = Lotto(winningNumbers)
                return lotto
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        throw MaxRetryException(MAX_RETRY_MSG)
    }

    private fun inputBonusNumber(lotto: Lotto) {
        repeat(MAX_RETRY) {
            try {
                val bonusNumber = inputView.readBonusNumber()
                lotto.setBonusNumber(bonusNumber)
                return
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
        throw MaxRetryException(MAX_RETRY_MSG)
    }

    private fun evaluateResults(lotto: Lotto, purchase: Purchase) {
        val result = lotto.compareNumbers(purchase.tickets)
        outputView.printStatistics(result)

        val totalPrize = lotto.calculateTotalPrize(result)
        val returnRate = purchase.calculateReturnRate(totalPrize)
        outputView.printReturnRate(returnRate)
    }

    companion object {
        private const val MAX_RETRY = 5
        private const val MAX_RETRY_MSG = "[ERROR] Maximum retry attempts exceeded."
    }

    class MaxRetryException(message: String, cause: Throwable? = null): RuntimeException(message, cause)
}