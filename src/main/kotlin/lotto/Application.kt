package lotto

fun main() {
    OutputView.printPurchaseAmount()
    val amount = InputView.readPurchaseAmount()
    val ticketCount = amount / 1000
    val lottoTickets = List(ticketCount) { LottoGenerator().generateLotto() }

    OutputView.printTicketCount(ticketCount)
    OutputView.printTickets(lottoTickets.map { it.getSortedNumbers() })

    OutputView.printWinningNumbers()
    val winningNumbers = InputView.readWinningNumbers()

    OutputView.printBonusNumber()
    val bonusNumber = InputView.readBonusNumber(winningNumbers)

    val lottoResults = LottoResult(winningNumbers, bonusNumber)
    lottoResults.analyzeResult(lottoTickets)

    OutputView.printResultStatistics(lottoResults.getStatistics())
    OutputView.printsReturnRate(lottoResults.calculateReturnRate(amount))
}