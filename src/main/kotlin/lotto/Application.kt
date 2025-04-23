package lotto

fun main() {
    val inputView = InputView()
    val outputView = OutputView()
    val lottoGame = LottoGame()

    try {
        val money = inputView.readMoney()
        val tickets = lottoGame.createLottoTickets(money)
        outputView.printLottoTickets(tickets)

        val winningNumbers = inputView.readWinningNumbers()
        val bonusNumber = inputView.readBonusNumber()

        val statistics = lottoGame.calculateWinningStatistics(tickets, winningNumbers, bonusNumber)
        outputView.printWinningStatistics(statistics)

        val totalPrize = lottoGame.calculateTotalPrize(statistics)
        val profitRate = lottoGame.calculateProfitRate(totalPrize, money)
        outputView.printProfitRate(profitRate)
    } catch (e: IllegalArgumentException) {
        println(e.message)
    }
}
