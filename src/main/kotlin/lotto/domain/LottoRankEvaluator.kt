package lotto.domain

object LottoRankEvaluator {

    fun evaluate(
        tickets: LottoTickets,
        winningNumbers: WinningNumbers,
        bonusNumber: BonusNumber
    ): Map<Rank, Int> {
        return tickets.getAll()
            .map { ticket ->
                val matchCount = winningNumbers.matchCount(ticket)
                val hasBonus = ticket.contains(bonusNumber.number.number)
                Rank.of(matchCount, hasBonus)
            }
            .groupingBy { it }
            .eachCount()
    }
}