package lotto

fun main() {
    val purchaseAmount = InputView.getPurchaseAmount()
    val purchasedLottos = LottoMachine.purchaseLottos(purchaseAmount)

    OutputView.printLottos(purchasedLottos)

    val winningNumbers = InputView.getWinningNumbers()
    val winningLottoTicket = Lotto(winningNumbers)
    val bonusNumberInput = InputView.getBonusNumber()
    val winningLotto = WinningLotto(winningLottoTicket, bonusNumberInput)

    val result = LottoResult(purchasedLottos, winningLotto)

    OutputView.printResult(result)

}
