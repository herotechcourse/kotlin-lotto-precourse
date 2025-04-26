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
        while (true) {
            try {
                val amount = inputView.purchaseAmount()
                    ?: throw IllegalArgumentException("[ERROR] Amount must be integer.")
                val purchase = LottoPurchase(amount)
                outputView.showPurchasedLotto(purchase.getLottos().size, purchase.getLottos())
                return purchase
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }

    }

    private fun inputWinningNum(): WinningLotto {
        while (true) {
            try {
                val winningNums = inputView.winningNumbers()
                val bonusNum = inputView.bonusNumber()
                return WinningLotto(winningNums, bonusNum)
            } catch (e: IllegalArgumentException) {
                println(e.message)
            }
        }
    }

    private fun calcResult(purchase: LottoPurchase,
                           winningLotto: WinningLotto): Pair<Map<Int, Int>, Double> {
        val results: List<LottoResult> = purchase.getLottos().map { lotto: Lotto ->
            LottoResult(winningLotto.match(lotto), winningLotto.matchBonus(lotto))
        }

        val prizes = listOf(5_000, 50_000, 1_500_000, 30_000_000, 2_000_000_000)
        val counted = results.groupingBy { it.getPrize() }.eachCount()
        val resultStatic: Map<Int, Int> = prizes.associateWith { prize -> counted[prize] ?: 0 }
        val totalReward: Int = results.sumOf { it -> it.getPrize() }
        val roi: Double = (totalReward / purchase.getAmount().toDouble()) * 100

        return Pair(resultStatic, roi)
    }

    fun processing() {
        val purchase = purchaseLottos()
        val winningLotto = inputWinningNum()
        val result = calcResult(purchase, winningLotto)
        outputView.showResultStatistics(result.first, result.second)
    }
}