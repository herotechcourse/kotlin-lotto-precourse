package lotto.view

import lotto.domain.LottoTicket
import lotto.domain.MatchLotto

object OutView {
    fun printTicket(tickets: List<LottoTicket>) {
        println()
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { println(it.getNumbers()) }
    }

    fun printStatistics(resultMap: Map<MatchLotto, Int>, purchaseAmount: Int) {
        println()
        println("Winning Statistics")
        println("---")

        val order = listOf(
            MatchLotto.FIFTH,
            MatchLotto.FOURTH,
            MatchLotto.THIRD,
            MatchLotto.SECOND,
            MatchLotto.FIRST
        )

        var totalReward = 0L

        for (rank in order) {
            val count = resultMap[rank] ?: 0
            val reward = rank.reward
            totalReward += reward * count
            println("${rank.description} (${String.format("%,d", reward)} KRW) – $count tickets")
        }

        val returnRate = totalReward.toDouble() / purchaseAmount * 100
        println("Total return rate is %.1f%%".format(returnRate))
    }
}
