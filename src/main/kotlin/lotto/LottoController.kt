package lotto

import lotto.view.InputView
import lotto.view.OutputView

class LottoController(
    val lottoGenerator: LottoGenerator
) {
    fun run() {
        val lottoTickets = purchaseTickets()
        calculateWinningStatistics(lottoTickets)
    }

    private fun purchaseTickets(): List<Lotto> {
        val lottoStore = InputHandler.retryOnInvalidInput { initLottoStore() }
        val lottoTickets = lottoStore.generateLottoTickets()
        OutputView.showLottoTickets(lottoTickets)
        return lottoTickets
    }

    private fun initLottoStore(): LottoStore {
        val purchaseAmount = InputView.readPurchaseAmount()
        return LottoStore(lottoGenerator, purchaseAmount)
    }

    private fun calculateWinningStatistics(lottoTickets: List<Lotto>) {
        val prizeRankCalculator = InputHandler.retryOnInvalidInput { initPrizeRankCalculator() }
        val result = prizeRankCalculator.calculateStatistics(lottoTickets)
        val profitRate = result.calculateProfitRate(lottoTickets)
        OutputView.showWinningStatistics(result.statistics, profitRate)
    }

    private fun initPrizeRankCalculator(): PrizeRankCalculator {
        val winningNumbers = InputView.readWinningNumbers()
        val bonusNumber = InputView.readBonusNumber()
        return PrizeRankCalculator(Lotto(winningNumbers.map { Number(it) }), Number(bonusNumber))
    }
}
