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
        outputView.printPurchasedLottos(lottos)

        // Get winning numbers
        val winningNumbers = inputView.readWinningNumbers()

        // Get bonus number
        val bonusNumber = inputView.readBonusNumber(winningNumbers)

        // Check results
        val results = lottoMachine.checkResults(lottos, winningNumbers, bonusNumber)
        val profitRate = lottoMachine.calculateProfitRate(results, amount)

        // Output results
        outputView.printResults(results, profitRate)

    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}