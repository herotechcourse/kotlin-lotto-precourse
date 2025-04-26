package lotto

class LottoResult(
    tickets: List<Lotto>,
    winningLotto: WinningLotto
) {
    val rankCount: Map<Rank, Int>
    val rate: Double

    init {
        val counts = tickets.groupingBy { winningLotto.match(it) }.eachCount().withDefault { 0 }
        rankCount = Rank.entries.associateWith { counts.getValue(it) }
        val totalPrize = rankCount.entries.sumOf { (rank, count) -> rank.prize.toLong() * count }
        val totalSpent = tickets.size * 1000L
        rate = if (totalSpent == 0L) 0.0 else totalPrize * 100.0 / totalSpent
    }
}
