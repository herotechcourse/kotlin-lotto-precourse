package lotto.view

import lotto.Lotto
import lotto.constants.Messages
import lotto.model.LottoRank
import lotto.model.LottoResult

object OutputView {
    fun purchaseLottery(lottery: List<Lotto>) {
        lottery.forEach { println(it) }
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
        println(Messages.Output.PURCHASE_COUNT.format(count))
    }

    fun profitRate(profitRate: Double) {
        println(Messages.Output.PROFIT_RATE.format(profitRate))
    }

    fun error(message: String?) {
        println("[ERROR] $message\n")
    }
}