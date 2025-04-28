package lotto

import camp.nextstep.edu.missionutils.Console
import lotto.domain.*
import lotto.presentation.InputView
import lotto.presentation.OutputView

fun main() {
    val purchase = InputView.readPurchaseAmount { Console.readLine() }
    val lottos = LottoMachine().buy(purchase)
    OutputView.printTickets(lottos)
    val calc = LottoResultCalculator(
        InputView.readWinningNumbers { Console.readLine() },
        InputView.readBonusNumber { Console.readLine() }
    )
    val stats = calc.calculateStats(lottos)
    OutputView.printStatistics(stats, calc.calculateRate(stats, purchase))
}
