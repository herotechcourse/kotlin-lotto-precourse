package lotto.controller

import lotto.InputHandler
import lotto.Lotto
import lotto.LottoPurchaseAmount
import lotto.LottoStore
import lotto.PrizeRankCalculator
import lotto.lottogenerator.LottoGenerator
import lotto.view.InputView
import lotto.view.OutputView

class LottoController(val lottoGenerator: LottoGenerator) {

    fun run() {
        val purchaseAmount = readPurchaseAmount()
        val lottoTickets = issueLottoTickets(purchaseAmount)
        calculateWinningResult(lottoTickets, purchaseAmount)
    }

    private fun readPurchaseAmount(): LottoPurchaseAmount {
        return InputHandler.retryOnInvalidInput {
            LottoPurchaseAmount(InputView.readPurchaseAmount())
        }
    }

    private fun issueLottoTickets(purchaseAmount: LottoPurchaseAmount): List<Lotto> {
        val lottoStore = LottoStore(lottoGenerator)
        val lottoTickets = lottoStore.issueLottoTickets(purchaseAmount)
        OutputView.showLottoTickets(lottoTickets)
        return lottoTickets
    }

    private fun calculateWinningResult(lottoTickets: List<Lotto>, purchaseAmount: LottoPurchaseAmount) {
        val prizeRankCalculator = initPrizeRankCalculator()
        val result = prizeRankCalculator.calculateStatistics(lottoTickets)
        val profitRate = result.calculateProfitRate(purchaseAmount)
        OutputView.showWinningResult(result.statistics(), profitRate)
    }

    private fun initPrizeRankCalculator(): PrizeRankCalculator {
        val winningLotto = InputHandler.retryOnInvalidInput { readWinningLotto() }
        return InputHandler.retryOnInvalidInput {
            val bonusNumber = InputView.readBonusNumber()
            PrizeRankCalculator(winningLotto, bonusNumber)
        }
    }

    private fun readWinningLotto(): Lotto {
        val winningNumbers = InputView.readWinningNumbers()
        return Lotto(winningNumbers.map { it })
    }
}
