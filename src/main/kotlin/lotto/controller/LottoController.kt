package lotto.controller

import lotto.model.LottoMaker
import lotto.model.LottoResult
import lotto.model.PrizeRank
import lotto.model.WinningNumber
import lotto.view.InputView
import lotto.view.OutputView

class LottoController {
    private val lottoMaker = LottoMaker()

    fun run() {
        val purchaseAmount = getInputMoney()
        val lotteries = lottoMaker.generateLotteries(purchaseAmount)
        OutputView.printLotteries(lotteries)

        val winningNumber = WinningNumber(getWinningNumber(), getBonusNumber())

        val lottoResult = LottoResult(winningNumber, lotteries)
        lottoResult.calculateLottoMatch()

        val result = lottoResult.getResult()
        val totalPurchase = lotteries.size * 1000
        val rateOfReturn = calculateRateOfReturn(result, totalPurchase)

        OutputView.printWinningStatistics(result)
        OutputView.printRateOfReturn(rateOfReturn)
    }

    private fun calculateRateOfReturn(result: Map<PrizeRank, Int>, purchaseAmount: Int): Double {
        val totalPrize = result.entries
            .filter { (rank, _) -> rank != PrizeRank.NONE }
            .sumOf { (rank, count) -> rank.prizeMoney * count }

        return (totalPrize.toDouble() / purchaseAmount) * 100
    }

    private fun getInputMoney(): Int {
        return InputView.moneyInput()
    }

    private fun getWinningNumber(): List<Int> {
        return InputView.winningNumberInput()
    }

    private fun getBonusNumber(): Int {
        return InputView.bonusNumberInput()
    }


}