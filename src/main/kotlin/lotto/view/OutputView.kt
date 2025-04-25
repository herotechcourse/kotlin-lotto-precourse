package lotto.view

import lotto.Lotto
import lotto.model.LottoRank
import lotto.model.LottoResult

object OutputView {
    fun printLottery(lottery: List<Lotto>) {
        lottery.forEach { println(it) }
    }

    fun printNewline() {
        println()
    }

    fun printStatistics(lottoResult: LottoResult) {
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
}