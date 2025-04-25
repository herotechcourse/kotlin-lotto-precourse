package lotto

class LottoTickets(private val tickets: List<Lotto>) {

    init {
        require(tickets.isNotEmpty()) { "LottoTickets must have at least 1 ticket." }
    }

    fun matchAll(winningLotto: WinningLotto): Map<Rank, Int> {
        return tickets
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

    fun size(): Int = tickets.size

    fun getTickets(): List<Lotto> = tickets.toList()

    companion object {
        private const val PERCENT = 100.0
    }
}
