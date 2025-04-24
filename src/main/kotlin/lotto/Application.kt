package lotto

fun main() {
    try {
        InputView
        InputView().readPurchaseAmount()
        InputView().readWinningNumbers()
        InputView().readBonusNumber()
    } catch (e: InputView.MaxRetryException) {
        println(e.message + " Exiting...")
        return
    }
}
