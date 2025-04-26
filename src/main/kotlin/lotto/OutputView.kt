package lotto

class OutputView {
    fun printPurchasedTickets(tickets: List<Lotto>) {
        println()
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { lotto ->
            println(lotto.getNumbers())
        }
        println()
    }

    fun printStatistics(lottoResult: LottoResult, purchaseSum: Int) {
        val statistics = lottoResult.getRankCounts()

        println()
        println("Winning Statistics")
        println("---")

        PrizeRank.entries.filter { it != PrizeRank.NONE }.sortedBy { it.matchCount }.forEach { rank ->
            val count = statistics.getOrDefault(rank, 0)
            val matchDescription = if (rank == PrizeRank.FIVE_MATCH_BONUS) "${rank.matchCount} Matches + Bonus Ball"
            else "${rank.matchCount} Matches"
            println("$matchDescription (${formatPrize(rank.prize)}) – $count tickets")
        }

        val returnRate = lottoResult.getProfitRate(purchaseSum)
        println("Total return rate is ${returnRate.toString().format("%.1f").replace(",", ".")}%.")
    }

    private fun formatPrize(prize: Int): String {
        return "${prize.toString().replace(Regex("(\\d)(?=(\\d{3})+$)"), "$1,")} KRW"
    }
}