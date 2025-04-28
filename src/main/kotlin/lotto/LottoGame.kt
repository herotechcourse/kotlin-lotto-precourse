package lotto

class LottoGame(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {
    fun play() {
        val amount = inputView.readPurchaseAmount()
        val purchase = Purchase(amount)
        outputView.displayTickets(purchase.tickets)

        val winningNumbers = inputView.readWinningNumbers()
        val lotto = Lotto(winningNumbers)

        val bonusNumber = inputView.readBonusNumber()
        lotto.addBonusNumber(bonusNumber)

        val result = lotto.compareNumbers(purchase.tickets)
        outputView.printStatistics(result)

        val totalPrize = lotto.calculateTotalPrize(result)
        val returnRate = purchase.calculateReturnRate(totalPrize)
        outputView.printReturnRate(returnRate)
    }
}