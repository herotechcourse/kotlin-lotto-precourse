package lotto


fun main() {
    // TODO: Implement the program
    val inputView = InputView()
    val outputView = OutputView()
    val lottoMachine = LottoMachine()

    try {
        // Get purchase amount
        val amount = inputView.readPurchaseAmount()
        // Get winning numbers
        val winningNumbers = inputView.readWinningNumbers()
        // Get bonus number
        val bonusNumber = inputView.readBonusNumber(winningNumbers)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}