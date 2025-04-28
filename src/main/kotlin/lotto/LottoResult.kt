package lotto

class LottoResult(

    private val winningNumbers: Lotto,
    private val bonusNumber: Int
) {

    fun calculateRanks(tickets: List<Lotto>): List<LottoRank> {
        return tickets.map { ticket ->
            val matchCount = ticket.getNumbers().count { it in winningNumbers.getNumbers() }
            val matchBonus = bonusNumber in ticket.getNumbers()
            LottoRank.valueOf(matchCount, matchBonus)
        }
    }
}
