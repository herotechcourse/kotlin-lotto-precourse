package lotto.service

import lotto.Lotto
import lotto.view.InputView
import lotto.view.OutputView
import lotto.LottoPurchase
import lotto.LottoResult
import lotto.WinningLotto

class LottoService (
    private val inputView: InputView,
    private val outputView: OutputView) {

    private fun purchaseLottos(): LottoPurchase {
        val amount = inputView.purchaseAmount()
            ?: throw IllegalArgumentException("[Error] Amount must be integer.")
        val purchase = LottoPurchase(amount)
        outputView.showPurchasedLotto(purchase.getLottos().size, purchase.getLottos())
        return purchase
    }

    private fun inputWinningNum(): WinningLotto {
        val winningNums = inputView.winningNumbers()
        val bonusNum = inputView.bonusNumber()
        return WinningLotto(winningNums, bonusNum)
    }

    private fun calcResult(purchase: LottoPurchase,
                           winningLotto: WinningLotto): Pair<Map<Int, Int>, Double> {
        val results: List<LottoResult> = purchase.getLottos().map { lotto: Lotto ->
            LottoResult(winningLotto.match(lotto), winningLotto.matchBonus(lotto))
        }

        val resultStatic: Map<Int, Int> = results.groupingBy { it -> it.getPrize() }.eachCount()
        val totalReward: Int = results.sumOf { it -> it.getPrize() }
        val roi: Double = totalReward / purchase.getAmount().toDouble()

        return Pair(resultStatic, roi)
    }

    fun processing() {
        val purchase = purchaseLottos()
        val winningLotto = inputWinningNum()
        val result = calcResult(purchase, winningLotto)
        outputView.showResultStatistics(result.first, result.second)
    }
}