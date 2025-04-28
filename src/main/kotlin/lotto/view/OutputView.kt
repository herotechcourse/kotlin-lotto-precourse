package lotto.view

import lotto.domain.Lotto
import lotto.domain.Prize

object OutputView {

    fun printPurchaseInfo(ticketCount: Int) {
        println("You have purchased $ticketCount tickets.")
    }

    fun printTickets(lottoTickets: List<Lotto>) {
        lottoTickets.forEach { lotto ->
            println(lotto.getNumbers().sorted())
        }
    }

    fun printLottoResults(results: Map<Prize, Int>) {
        println("Winning Statistics")
        println("---")

        val prizesInOrder = listOf(
            Prize.FIFTH,
            Prize.FOURTH,
            Prize.THIRD,
            Prize.SECOND,
            Prize.FIRST
        )

        prizesInOrder.forEach { prize ->
            val count = results.getOrDefault(prize, 0)

            if (prize == Prize.SECOND) {
                println("${prize.matchCount} Matches + Bonus Ball (${formatMoney(prize.prizeMoney)} KRW) – $count tickets")
            } else {
                println("${prize.matchCount} Matches (${formatMoney(prize.prizeMoney)} KRW) – $count tickets")
            }
        }
    }

    fun printProfitRate(results: Map<Prize, Int>, purchaseAmount: Int) {
        val totalPrizeMoney = results.entries.sumOf { (prize, count) -> prize.prizeMoney * count }
        val profitRate = (totalPrizeMoney.toDouble() / purchaseAmount) * 100

        println("Total return rate is ${"%.1f".format(profitRate)}%.")
    }

    private fun formatMoney(amount: Int): String {
        return "%,d".format(amount)
    }
}
