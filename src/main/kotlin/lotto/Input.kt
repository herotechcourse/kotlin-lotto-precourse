package lotto

class InputView(private val outputView: OutputView) {
    fun readPurchaseAmount(): String {
        outputView.promptPurchase()
        return readlnOrNull() ?: ""
    }

    fun readWinningNumbers(): String {
        outputView.promptWinningNumbers()
        return readlnOrNull() ?: ""
    }

    fun readBonusNumber(): String {
        outputView.promptBonusNumber()
        return readlnOrNull() ?: ""
    }
}