package lotto.view
import lotto.Rank
import lotto.Lotto

object OutputView {

    fun printPurchasedTickets(lottos: List<Lotto>) {
        println("You have purchased ${lottos.size} tickets.")
        lottos.forEach { lotto ->
            println(lotto.getNumbers())
        }
    }

    fun printStatistics(result: Map<Rank, Int>, purchaseAmount: Int) {
        println("\nWinning Statistics")
        println("---")
        Rank.values()
            .filter { it != Rank.MISS }
            .sortedByDescending { it.reward }
            .forEach { rank ->
                val count = result[rank] ?: 0
                println("${formatRank(rank)} – ${count} tickets")
            }
        printProfitRate(result, purchaseAmount)
    }

    private fun formatRank(rank: Rank): String {
        return when (rank) {
            Rank.FIRST -> "6 Matches (2,000,000,000 KRW)"
            Rank.SECOND -> "5 Matches + Bonus Ball (30,000,000 KRW)"
            Rank.THIRD -> "5 Matches (1,500,000 KRW)"
            Rank.FOURTH -> "4 Matches (50,000 KRW)"
            Rank.FIFTH -> "3 Matches (5,000 KRW)"
            else -> ""
        }

    }

    private fun printProfitRate(result: Map<Rank, Int>, purchaseAmount: Int) {
        val totalReward = result.entries.sumOf { (rank, count) -> rank.reward.toLong() * count }
        val profitRate = totalReward.toDouble() / purchaseAmount * 100
        println("Total return rate is ${"%.1f".format(profitRate)}%.")
    }



}
