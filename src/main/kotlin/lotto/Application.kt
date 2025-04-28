package lotto

import lotto.domain.LottoFactory
import lotto.service.LottoResultChecker
import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val purchaseAmount = InputView.readPurchaseAmount()
    println()

    val ticketCount = purchaseAmount / TICKET_PRICE
    val lottoTickets = LottoFactory.createLottos(ticketCount)

    OutputView.printPurchaseInfo(ticketCount)
    OutputView.printTickets(lottoTickets)
    println()

    val winningNumbers = InputView.readWinningNumbers()
    println()
    val bonusNumber = InputView.readBonusNumber(winningNumbers)
    println()

    val result = LottoResultChecker.checkResults(lottoTickets, winningNumbers, bonusNumber)

    OutputView.printLottoResults(result)
    OutputView.printProfitRate(result, purchaseAmount)
}
