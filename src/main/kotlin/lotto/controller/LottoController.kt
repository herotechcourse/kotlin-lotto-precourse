package lotto.controller

import lotto.InputHandler
import lotto.Lotto
import lotto.LottoNumber
import lotto.LottoPurchaseAmount
import lotto.LottoStore
import lotto.PrizeRankCalculator
import lotto.lottogenerator.LottoGenerator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    val lottoGenerator: LottoGenerator
) {
    fun run() {
        val purchaseAmount = InputHandler.retryOnInvalidInput { LottoPurchaseAmount(InputView.readPurchaseAmount()) }
        val lottoTickets = issueLottoTickets(purchaseAmount)
        calculateWinningResult(lottoTickets, purchaseAmount)
    }

    private fun issueLottoTickets(purchaseAmount: LottoPurchaseAmount): List<Lotto> {
        val lottoStore = LottoStore(lottoGenerator)
        val lottoTickets = lottoStore.sellLottoTickets(purchaseAmount)
        OutputView.showLottoTickets(lottoTickets)
        return lottoTickets
    }

    private fun initPrizeRankCalculator(): PrizeRankCalculator {
        val winningNumbers = InputView.readWinningNumbers()
        val bonusNumber = InputView.readBonusNumber()
        val winningLotto = Lotto(winningNumbers.map { LottoNumber(it) })
        return PrizeRankCalculator(winningLotto, LottoNumber(bonusNumber))
    }

    private fun calculateWinningResult(lottoTickets: List<Lotto>, purchaseAmount: LottoPurchaseAmount) {
        val prizeRankCalculator = InputHandler.retryOnInvalidInput { initPrizeRankCalculator() }
        val result = prizeRankCalculator.calculateStatistics(lottoTickets)
        val profitRate = result.calculateProfitRate(purchaseAmount)
        OutputView.showWinningStatistics(result.statistics(), profitRate)
    }
}
