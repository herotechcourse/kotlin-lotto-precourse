package lotto

class LottoResult(
    lottos: List<Lotto>,
    private val winningLotto: WinningLotto
) {
    val rankCount: Map<LottoRank, Int>
    var rate: Double = 0.0

    init {
        val counts = lottos.groupingBy { winningLotto.match(it) }.eachCount().withDefault { 0 }
        rankCount = LottoRank.entries.associateWith { counts.getValue(it) }
        val totalPrize = rankCount.entries.sumOf { (rank, count) -> rank.prize.toLong() * count }
        val totalSpent = lottos.size * 1000L
        rate = if (totalSpent == 0L) 0.0 else totalPrize * 100.0 / totalSpent
    }

}