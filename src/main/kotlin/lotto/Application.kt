package lotto

import lotto.domain.LottoFactory
import lotto.service.LottoResultChecker
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    // Entry point that orchestrates the whole flow:
    // [x] InputView gets input
    // [x] LottoGenerator creates tickets
    // [x] ResultChecker calculates result
    // [x] OutputView prints tickets
    // [x] OutputView prints statistics

    val purchaseAmount = InputView.readPurchaseAmount()
    val ticketCount = purchaseAmount / 1000
    val lottoTickets = LottoFactory.createLottos(ticketCount)

    OutputView.printPurchaseInfo(ticketCount)
    OutputView.printTickets(lottoTickets)

    val winningNumbers = InputView.readWinningNumbers()
    val bonusNumber = InputView.readBonusNumber(winningNumbers)

    val result = LottoResultChecker.checkResults(lottoTickets, winningNumbers, bonusNumber)

    OutputView.printLottoResults(result)
    OutputView.printProfitRate(result, purchaseAmount)
}
