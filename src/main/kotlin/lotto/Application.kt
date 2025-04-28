package lotto

import lotto.domain.WinningLotto
import lotto.generator.LottoGenerator
import lotto.io.InputView
import lotto.io.OutputView
import lotto.service.LottoResultCalculator
import lotto.service.ProfitCaculator

fun main() {
    // purchase lottos
    val ticket: Int = InputView.inputPurchaseAmount()
    val userLottos: List<Lotto> = List(ticket){LottoGenerator.generate()}
    OutputView.printUsertickets(userLottos)

    // last week winning and bonus lotto
    val winningNumbers: List<Int> = InputView.inputWinningNumbers()
    val bonusNumber: Int = InputView.inputBonusNumber()
    val winningLotto = WinningLotto(winningNumbers, bonusNumber)

    // count matched ranks
    val rankCountMap = LottoResultCalculator(userLottos, winningLotto).countRanks()
    OutputView.printWinningStatistics(rankCountMap)

    // profit = total prize / amount
    val totalProfit = ProfitCaculator.calculate(rankCountMap, ticket)
    OutputView.printProfitResult(totalProfit)

}
