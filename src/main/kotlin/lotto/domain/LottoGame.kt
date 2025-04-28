package lotto.domain

class LottoGame(
    private val purchaseAmount: Int,
    private val winningNumbers: Set<Int>,
    private val bonusNumber: Int
) {
    private val ticketCount: Int = purchaseAmount / 1_000

    private val tickets: List<LottoTicket> = List(ticketCount) {
        LottoTicket.createRandom()
    }

    fun createTickets(): List<LottoTicket> = tickets

    fun calculateResults(): LottoStatistics {
        val results = tickets.map { t ->
            LottoResult.of(t, winningNumbers, bonusNumber)
        }
        return LottoStatistics(results, purchaseAmount)
    }
}
