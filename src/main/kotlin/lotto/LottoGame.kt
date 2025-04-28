package lotto

class LottoGame(
    private val inputView: InputView = InputView(),
    private val outputView: OutputView = OutputView()
) {

    fun play() {
        val purchase = purchaseTickets()
        val lotto = inputWinningNumbers()
        evaluateResults(lotto, purchase)
    }

    private fun purchaseTickets(): Purchase {
        val amount = inputView.readPurchaseAmount()
        val purchase = Purchase(amount)
        outputView.displayTickets(purchase.tickets)

        return purchase
    }

    private fun inputWinningNumbers(): Lotto {
        val winningNumbers = inputView.readWinningNumbers()
        val lotto = Lotto(winningNumbers)

        val bonusNumber = inputView.readBonusNumber()
        lotto.addBonusNumber(bonusNumber)

        return lotto
    }

    private fun evaluateResults(lotto: Lotto, purchase: Purchase) {
        val result = lotto.compareNumbers(purchase.tickets)
        outputView.printStatistics(result)

        val totalPrize = lotto.calculateTotalPrize(result)
        val returnRate = purchase.calculateReturnRate(totalPrize)
        outputView.printReturnRate(returnRate)
    }
}