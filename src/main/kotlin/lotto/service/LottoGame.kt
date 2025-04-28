package lotto.service

import lotto.model.Lotto
import lotto.model.LottoResult
import lotto.model.WinningLotto
import lotto.view.InputView
import lotto.view.OutputView

class LottoGame(
    private val lottoMachine: LottoMachine,
    private val inputView: InputView,
    private val outputView: OutputView
) {

    fun play() {
        val (purchaseAmount, lottos) = purchaseLottos()
        outputView.printLottos(lottos)

        val winningLotto = getWinningLotto()
        val lottoResult = calculateResults(lottos, winningLotto)

        outputView.printResults(lottoResult)
        outputView.printProfitRate(lottoResult.calculateProfitRate(purchaseAmount))
    }

    private fun purchaseLottos(): Pair<Int, List<Lotto>> {
        val purchaseAmount = getValidPurchaseAmount()
        val lottos = lottoMachine.issue(purchaseAmount)
        return Pair(purchaseAmount, lottos)
    }

    private fun getValidPurchaseAmount(): Int {
        while (true) {
            try {
                return inputView.readPurchaseAmount()
            } catch (e: IllegalArgumentException) {
                outputView.printError(e.message ?: "[ERROR] Invalid input")
            }
        }
    }

    private fun getWinningLotto(): WinningLotto {
        while (true) {
            try {
                val winningNumbers = inputView.readWinningNumbers()
                val bonusNumber = inputView.readBonusNumber()
                return WinningLotto(winningNumbers, bonusNumber)
            } catch (e: IllegalArgumentException) {
                outputView.printError(e.message ?: "[ERROR] Invalid input")
            }
        }
    }

    private fun calculateResults(
        lottos: List<Lotto>,
        winningLotto: WinningLotto
    ): LottoResult {
        val result = LottoResult()

        lottos.forEach { lotto ->
            val rank = winningLotto.match(lotto)
            result.addRank(rank)
        }

        return result
    }
}