package lotto

class LottoTickets(private val tickets: List<Lotto>) {

    init {
        require(tickets.isNotEmpty()) { "LottoTickets must have at least 1 ticket." }
    }

    fun evaluate(winningLotto: WinLotto): WinningStatistics = WinningStatistics(winningLotto.matchAll())

    fun getTickets(): List<Lotto> = tickets.toList()

    private fun WinLotto.matchAll(): Map<Rank, Int> = tickets
        .map { match(it) }
        .groupingBy { it }
        .eachCount()

}
