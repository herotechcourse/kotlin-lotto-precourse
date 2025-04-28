package lotto

class LottoResult(
    tickets: List<LottoTicket>,
    winningLotto: WinningLotto
) {
    private val results: Map<Rank, Int> = tickets
        .map { winningLotto.match(it) }
        .groupingBy { it }
        .eachCount()

    fun rankCount(rank: Rank): Int = results[rank] ?: 0

    fun profitRate(): Double {
        val totalPrize = results.entries.sumOf { it.key.prize * it.value }
        val spent = results.values.sum() * 1000
        return String.format("%.1f", (totalPrize.toDouble() / spent) * 100).toDouble()
    }
}
