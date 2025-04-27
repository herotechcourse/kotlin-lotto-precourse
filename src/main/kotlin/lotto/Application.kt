package lotto

import lotto.service.LottoMachine
import lotto.ui.ConsoleIO
import lotto.ui.InputView
import lotto.ui.OutputView

fun main() {
    val inputView = InputView(ConsoleIO())
    val outputView = OutputView(ConsoleIO())

    val amount = inputView.getPurchaseAmount()

    val lottoMachine = LottoMachine()
    val purchasedLottos = lottoMachine.issueTickets(amount)
    outputView.printPurchasedLottos(purchasedLottos)

    val winningLotto = inputView.getWinningNumbers()
    val bonusNumber = inputView.getBonusNumber(winningLotto)

    val stats = purchasedLottos.calculateWinningStats(winningLotto, bonusNumber)
    outputView.printWinningStats(stats)
    outputView.printProfitRate(stats, amount)
}
