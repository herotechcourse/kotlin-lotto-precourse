package lotto

class LottoResult(
    private val winningLotto: WinningLotto,
    private val tickets: List<Lotto>
) {
    private val counts = mutableMapOf<Rank, Int>()

    init {
        Rank.values().forEach { counts[it] = 0 }
        tickets.forEach { ticket ->
            val hits = ticket.countMatching(winningLotto.winningNumbers)
            val bonus = ticket.contains(winningLotto.bonusNumber)
            val rank = Rank.from(hits, bonus)
            counts[rank] = counts.getOrDefault(rank, 0) + 1
        }
    }

    /** How many tickets got exactly [matchCount] matches (and the bonus if requested) */
    fun matchCount(matchCount: Int, bonus: Boolean = false): Int =
        counts[Rank.from(matchCount, bonus)] ?: 0

    /** Percentage return: (total prizes won) / (total spent) * 100 */
    fun getProfitRate(): Double {
        val spent = tickets.size * 1000
        val won = Rank.values().sumOf { it.prize.toLong() * (counts[it] ?: 0) }
        return if (spent > 0) won.toDouble() / spent * 100 else 0.0
    }
}
