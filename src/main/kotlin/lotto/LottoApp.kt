package lotto

class LottoApp(
    private val lottoService: LottoService,
    private val inputView: InputView,
    private val outputView: OutputView
) {

    fun run() {
        val purchaseAmount = inputView.readPurchaseAmount()

        lottoService.purchaseTickets(purchaseAmount)
        outputView.displayPurchasedTickets(lottoService.getTickets())

        val winnerNumbers = inputView.readWinnerNumbers()
        lottoService.setWinnerNumbers(winnerNumbers)

        val bonusNumber = inputView.readBonusNumber(lottoService.getWinnerNumbers())
        lottoService.setBonusNumber(bonusNumber)

        val rankList = lottoService.compareTickets()
        outputView.displayWinningStatistics(rankList)

        val returnRate = lottoService.calculateReturnRate(rankList, purchaseAmount)
        outputView.displayReturnRate(returnRate)
    }
}