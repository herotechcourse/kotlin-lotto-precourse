package lotto.controller

import lotto.domain.LottoGenerator
import lotto.domain.LottoRanker
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    private val inputView: InputView,
    private val outputView: OutputView,
    private val lottoGenerator: LottoGenerator,
    private val lottoRanker: LottoRanker
) {
    fun run() {
        val purchaseAmount = inputView.getPurchaseAmount()

        val lottos = lottoGenerator.generate(purchaseAmount)
        outputView.printTickets(lottos)

        val winningNumbers = inputView.getWinningNumbers()
        val bonusNumber = inputView.getBonusNumber()

        val statistics = lottoRanker.rankLotto(lottos, winningNumbers, bonusNumber)
        val profit = lottoRanker.calculateProfit(lottos, statistics)
        outputView.printStatistics(statistics, profit)
    }
}