package lotto.domain

class LottoGame(
    private val purchaseAmount: Int,
    private val winningNumbers: Set<Int>,
    private val bonusNumber: Int
) {
    private val ticketCount = purchaseAmount / 1_000

    fun createTickets(): List<LottoTicket> {
        val tickets = mutableListOf<LottoTicket>()
        repeat(ticketCount) {
            tickets += LottoTicket.createRandom()
        }
        return tickets
    }
    fun calculateResults(): LottoStatistics {
        val tickets = createTickets()
        val results = tickets.map { ticket ->
            LottoResult.of(ticket, winningNumbers, bonusNumber)
        }
        return LottoStatistics(results, purchaseAmount)
    }
}
