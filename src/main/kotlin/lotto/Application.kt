package lotto

import lotto.view.InputView
import lotto.view.OutputView

fun main() {
    val amount: Int = InputView.getPurchaseAmount()

    val lottos: List<Lotto> = LottoGenerator.generate(amount)
    OutputView.printTickets(lottos)

    val winningNumbers: List<Int> = InputView.getWinningNumbers()
    val bonusNumber: Int = InputView.getBonusNumber()

    val ranker = LottoRanker(lottos, winningNumbers, bonusNumber)

    val statistics = ranker.rankLotto()
    val profit = ranker.calculateProfit(statistics)
    OutputView.printStatistics(statistics, profit)
}
