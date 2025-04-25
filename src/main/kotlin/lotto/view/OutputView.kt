package lotto.view

import lotto.Lotto
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
            println("${rank.description} – ${lottoResult.getCount(rank)} tickets")
        }
    }

    fun message(message: String) {
        println(message)
    }

    fun purchaseCount(count: Int) {
        println("You have purchased $count tickets.")
    }


    fun profitRate(profitRate: Double) {
        println("Total return rate is $profitRate%.")
    }

}