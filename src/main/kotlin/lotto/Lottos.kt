package lotto

class Lottos(private val values: List<Lotto>) {

    fun matchAll(winningLotto: WinningLotto): Map<Rank, Int> {
        return values
            .map { winningLotto.match(it) }
            .groupingBy { it }
            .eachCount()
    }

    fun profitRate(winningLotto: WinningLotto): Double {
        val totalPrize: Prize = calculateTotalPrize(winningLotto)
        val cost: Money = Money.fromTicketCount(size())

        return (totalPrize / cost) * PERCENT
    }

    private fun calculateTotalPrize(winningLotto: WinningLotto): Prize {
        val totalPrize: Int = matchAll(winningLotto)
            .entries
            .sumOf { (rank, count) -> rank.prize * count }

        return Prize(totalPrize.toLong())
    }

    fun size(): Int = values.size

    fun getValues(): List<Lotto> = values.toList()

    companion object {
        private const val PERCENT = 100.0
    }
}
