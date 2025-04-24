package lotto


fun main() {
    // TODO: Implement the program
    val inputView = InputView()
    val outputView = OutputView()
    val lottoMachine = LottoMachine()

    try {
        // Get purchase amount
        val amount = inputView.readPurchaseAmount()

        // Buy lottery tickets
        val lottos = lottoMachine.buyLottos(amount)

        // Get winning numbers
        val winningNumbers = inputView.readWinningNumbers()

        // Get bonus number
        val bonusNumber = inputView.readBonusNumber(winningNumbers)

        // Check results
        val results = lottoMachine.checkResults(lottos, winningNumbers, bonusNumber)
        println(results)

    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}