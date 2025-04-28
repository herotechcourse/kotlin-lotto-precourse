package lotto

class LottoGame(
    private val lottoMachine: LottoMachine,
    private val inputHandler: InputHandler,
    private val outputHandler: OutputHandler
) {
    fun run() {
        try {
            val purchaseAmount = getPurchaseAmount()
            
            val lottoCount = purchaseAmount / 1000
            val lottos = lottoMachine.generateLottos(lottoCount)

            outputHandler.printPurchasedLottos(lottos)

            val winningNumbers = getWinningNumbers()
            val bonusNumber = getBonusNumber(winningNumbers)

            val winningStatistics = lottoMachine.calculateWinningStatistics(lottos, winningNumbers, bonusNumber)
            
            outputHandler.printWinningStatistics(winningStatistics, purchaseAmount)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }

    private fun getPurchaseAmount(): Int {
        return retryOnException { inputHandler.getPurchaseAmount() }
    }

    private fun getWinningNumbers(): List<Int> {
        return retryOnException { inputHandler.getWinningNumbers() }
    }

    private fun getBonusNumber(winningNumbers: List<Int>): Int {
        return retryOnException { inputHandler.getBonusNumber(winningNumbers) }
    }
            
    private fun <T> retryOnException(action: () -> T): T {
        return try {
            action()
        } catch (e: IllegalArgumentException) {
            println(e.message)
            retryOnException(action)
        }
    }
} 