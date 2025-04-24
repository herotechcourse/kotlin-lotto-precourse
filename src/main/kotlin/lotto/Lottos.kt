package lotto

class Lottos(private val values: List<Lotto>) {

    fun matchAll(winningLotto: WinningLotto): Map<Rank, Int> {
        return values
            .map { winningLotto.match(it) }
            .groupingBy { it }
            .eachCount()
    }

    fun profitRate(winningLotto: WinningLotto): Double {
        val totalPrize: Money = calculateTotalPrize(winningLotto)
        val cost: Money = Money.fromTicketCount(size())

        if (cost.isZero()) {
            return 0.0
        }
        return (totalPrize / cost) * PERCENT
    }

    private fun calculateTotalPrize(winningLotto: WinningLotto): Money {
        val totalPrize: Long = matchAll(winningLotto)
            .entries
            .sumOf { (rank, count) -> rank.prize * count }

        return Money(totalPrize)
    }

    fun size(): Int = values.size

    fun getValues(): List<Lotto> = values.toList()

    companion object {
        private const val PERCENT = 100.0
    }
}
