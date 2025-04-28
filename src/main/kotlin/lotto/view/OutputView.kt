package lotto.view

import lotto.domain.Rank
import lotto.service.Statistics

object OutputView {
    fun printTickets(tickets: List<List<Int>>) {
        println("${tickets.size}개를 구매했습니다.")
        tickets.forEach { println(it) }
        println()
    }

    fun printStatistics(stats: Statistics, purchaseAmount: Int) {
        println("당첨 통계")
        stats.rankCounts.forEach { (rank, count) ->
            println("${rank.matches}개 일치 (${rank.prize}원) - ${count}개")
        }
        val rate = stats.totalPrize.toDouble() / purchaseAmount * 100
        println("총 수익률은 %.1f%% 입니다.".format(rate))
    }
}
