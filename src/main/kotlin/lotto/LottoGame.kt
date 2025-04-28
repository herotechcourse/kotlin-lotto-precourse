package lotto

class LottoGame(
    private val lottoMachine: LottoMachine,
    private val inputHandler: InputHandler,
    private val outputHandler: OutputHandler
) {
    fun run() {
        try {
            val purchaseAmount = inputHandler.getPurchaseAmount()
            
            val lottoCount = purchaseAmount / 1000
            val lottos = lottoMachine.generateLottos(lottoCount)

            outputHandler.printPurchasedLottos(lottos)

            val winningNumbers = inputHandler.getWinningNumbers()
            val bonusNumber = inputHandler.getBonusNumber(winningNumbers)

            val winningStatistics = lottoMachine.calculateWinningStatistics(lottos, winningNumbers, bonusNumber)
            
            outputHandler.printWinningStatistics(winningStatistics, purchaseAmount)
        } catch (e: IllegalArgumentException) {
            println(e.message)
        }
    }
} 