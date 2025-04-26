package lotto.view

import lotto.Lotto
import lotto.constants.Messages
import lotto.model.LottoRank
import lotto.model.LottoResult

object OutputView {
    fun purchaseLottery(lottery: List<Lotto>) {
        lottery.forEach { println(it) }
        newline()
    }

    fun newline() {
        println()
    }

    fun lottoStatistics(lottoResult: LottoResult) {
        val ranksInOrder = listOf(
            LottoRank.FIFTH,
            LottoRank.FOURTH,
            LottoRank.THIRD,
            LottoRank.SECOND,
            LottoRank.FIRST
        )
        for (rank in ranksInOrder) {
            println(Messages.Output.LOTTO_RESULT_STATISTICS.format(rank.description, lottoResult.getCount(rank)))
        }
    }

    fun message(message: String) {
        println(message)
    }

    fun purchaseCount(count: Int) {
        newline()
        println(Messages.Output.PURCHASE_COUNT.format(count))
    }

    fun profitRate(profitRate: Double) {
        println(Messages.Output.PROFIT_RATE.format(profitRate))
    }

    fun error(message: String?) {
        println(Messages.Error.FORMAT.format(message))
    }

    fun winningStatistics(result: LottoResult, purchaseAmount: Int) {
        newline()
        message(Messages.Output.WINNING_STATISTICS_TITLE)
        lottoStatistics(result)
        profitRate(result.calculateProfitRate(purchaseAmount))
    }
}