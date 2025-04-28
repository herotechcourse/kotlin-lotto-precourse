package lotto

object OutputView {
    fun printIssuedLottos(lottos: List<Lotto>) {
        println("\n${PURCHASED_TICKETS_PREFIX} ${lottos.size} tickets.")
        lottos.forEach { println(it.getNumbers()) }
    }

    fun printWinningStatistics(result: Result) {
        println("\n${WINNING_STATISTICS_HEADER}\n${WINNING_STATISTICS_SEPARATOR}")

        listOf(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST)
            .forEach { rank ->
                println(formatRank(rank, result.rankCounts.getOrDefault(rank, 0)))
            }

        println("$TOTAL_RETURN_RATE_PREFIX ${String.format("%,.1f", result.profitRate())}%.")
    }

    private fun formatRank(rank: Rank, count: Int): String {
        return when (rank) {
            Rank.SECOND -> "${rank.matchCount} Matches + Bonus Ball (${formatMoney(rank.prize)}) – ${count} tickets"
            else -> "${rank.matchCount} Matches (${formatMoney(rank.prize)}) – ${count} tickets"
        }
    }

    private fun formatMoney(amount: Int): String {
        return String.format("%,d KRW", amount)
    }

    private const val PURCHASED_TICKETS_PREFIX = "You have purchased"
    private const val WINNING_STATISTICS_HEADER = "Winning Statistics"
    private const val WINNING_STATISTICS_SEPARATOR = "---"
    private const val TOTAL_RETURN_RATE_PREFIX = "Total return rate is"
}