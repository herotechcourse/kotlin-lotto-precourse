package lotto

fun main() {
    val inputHandler = InputHandler()
    val outputHandler = OutputHandler()
    val lottoMachine = LottoMachine()

    val purchaseAmount = inputHandler.getPurchaseAmount()

    val lottoCount = purchaseAmount / 1000
    val lottos = lottoMachine.generateLottos(lottoCount)

    outputHandler.printPurchasedLottos(lottos)

    val winningNumbers = inputHandler.getWinningNumbers()
    val bonusNumber = inputHandler.getBonusNumber(winningNumbers)
}
