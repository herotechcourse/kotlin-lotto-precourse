package lotto.domain

import lotto.Lotto

object LottoResult {
    var totalPrize = 0
        private set

    fun checkResult(tickets: List<Lotto>, winningLotto: WinningLotto): Int {
        tickets.forEach { ticket ->
            val numbers = ticket.getNumbers()
            ticket.settMatchCount( numbers.count { it in winningLotto.ticket } )
            if (winningLotto.bonus in numbers) {
                ticket.markBonusMatched()
            }
            val rank = Rank.of(ticket.matchCount, ticket.bonusMatched)
            ticket.setRank(rank)
            totalPrize += rank.prize
        }
        return (totalPrize)
    }
}