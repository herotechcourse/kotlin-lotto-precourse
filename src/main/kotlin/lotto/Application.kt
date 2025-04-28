package lotto

import lotto.domain.*
import lotto.presentation.InputView
import lotto.presentation.OutputView

fun main() {
    val purchase = InputView.readPurchaseAmount()
    val lottos = LottoMachine().buy(purchase)
    OutputView.printTickets(lottos)
    val calc = LottoResultCalculator(
        InputView.readWinningNumbers(),
        InputView.readBonusNumber()
    )
    val stats = calc.calculateStats(lottos)
    OutputView.printStatistics(stats, calc.calculateRate(stats, purchase))
}
