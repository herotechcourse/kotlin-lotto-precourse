package lotto

class LottoTickets(private val tickets: List<Lotto>) {

    init {
        require(tickets.isNotEmpty()) { "LottoTickets must have at least 1 ticket." }
    }

    fun evaluate(winningLotto: WinningLotto): WinningStatistics = WinningStatistics(matchAll(winningLotto))

    fun getTickets(): List<Lotto> = tickets.toList()

    private fun matchAll(winningLotto: WinningLotto): Map<Rank, Int> = tickets
        .map { winningLotto.match(it) }
        .groupingBy { it }
        .eachCount()

}
