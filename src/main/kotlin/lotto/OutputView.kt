package lotto

object OutputView {

    fun printPurchasedTickets(lottos: List<Lotto>) {
        println("You have purchased ${lottos.size} tickets.")
        lottos.forEach { println(it.getNumbers()) }
    }

    fun printWinningStatistics(prizeRanks: List<PrizeRank?>) {
        println("Winning Statistics\n---")
        val rankCounts = countPrizeRanks(prizeRanks)
        PrizeRank.values()
            .sortedWith(compareBy<PrizeRank> { it.matchCount }.thenBy { it.requiresBonus })
            .forEach { rank ->
                val count = rankCounts[rank] ?: 0
                val formattedPrize = "%,d".format(rank.prizeAmount)
                println("${rank.matchCount} Matches${if (rank.requiresBonus) " + Bonus Ball" else ""} (${formattedPrize} KRW) \u2013 $count ticket${if ((count != 1) or true) "s" else ""}")
            }
    }

    fun printProfitRate(profitRate: Float) {
        println("Total return rate is ${"%.1f".format(profitRate)}%.")
    }

    fun printError(message: String) {
        println("[ERROR] $message")
    }
}
