package lotto.model

data class MatchResults(
    private val results: Map<MatchRank, Int>
) {
    fun countOf(rank: MatchRank): Int =
        results.getOrDefault(rank, 0)

    fun profitRate(): Double {
        val lottoCount = results.values.sum()
        return (totalPrize().toDouble() / (lottoCount * LOTTO_PRICE))
    }

    private fun totalPrize(): Int =
        results.entries.sumOf { (rank, count) -> rank.prize * count }
}
