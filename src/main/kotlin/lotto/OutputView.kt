package lotto

object OutputView {
    fun printIssuedLottos(lottos: List<Lotto>) {
        println("\nYou have purchased ${lottos.size} tickets.")
        lottos.forEach { println(it.getNumbers()) }
    }

    fun printWinningStatistics(result: Result) {
        println("\nWinning Statistics\n---")

        listOf(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST)
            .forEach { rank ->
                println(formatRank(rank, result.rankCounts.getOrDefault(rank, 0)))
            }

        println("Total return rate is ${String.format("%,.1f", result.profitRate())}%.")
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
}