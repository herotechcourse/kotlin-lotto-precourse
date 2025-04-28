package lotto

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()
    val ticketAmount = LottoTicketCalculator.calculateTicketAmount(purchaseAmount)
    OutputView.printLine()
    OutputView.printPurchasedTickets(ticketAmount)

    val lottoList = LottoGenerator.createRandomLottos(ticketAmount)
    OutputView.printLottoList(lottoList)
    OutputView.printLine()

    val winningLotto = InputView.readWinningLotto()
    OutputView.printLine()
    val bonusNumber = InputView.readBonusNumber(winningLotto.getNumbers())

    val evaluation = LottoEvaluation(winningLotto.getNumbers(), bonusNumber)
    val result = evaluation.evaluate(lottoList, purchaseAmount)

    OutputView.printLine()
    result.printStatistics()
    result.printReturnRate()
}
