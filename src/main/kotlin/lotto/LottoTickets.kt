package lotto

class LottoTickets(private val tickets: List<Lotto>) {

    init {
        require(tickets.isNotEmpty()) { "LottoTickets must have at least 1 ticket." }
    }

    fun matchAll(winningLotto: WinningLotto): Map<Rank, Int> = tickets
        .map { winningLotto.match(it) }
        .groupingBy { it }
        .eachCount()

    fun profitRate(winningLotto: WinningLotto): Double {
        val totalPrize: Prize = calculateTotalPrize(winningLotto)
        val cost: Money = Money.fromTicketCount(tickets.size)

        return (totalPrize / cost) * PERCENT
    }

    private fun calculateTotalPrize(winningLotto: WinningLotto): Prize = matchAll(winningLotto)
        .entries
        .map { (rank, count) -> rank.prize * count }
        .fold(Prize.ZERO) { acc, prize -> acc + prize }

    fun getTickets(): List<Lotto> = tickets.toList()

    companion object {
        private const val PERCENT = 100.0
    }
}
