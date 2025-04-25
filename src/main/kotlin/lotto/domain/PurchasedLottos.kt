package lotto.domain

import lotto.Lotto

class PurchasedLottos(private val tickets: List<Lotto>) {
    fun count(): Int {
        return tickets.size
    }

    fun getAllTickets(): List<Lotto> {
        return tickets
    }

    fun calculateWinningStats(winningLotto: Lotto, bonusNumber: Int):WinningStats {
        val result = mutableMapOf<WinningRank, Int>()
        for (ticket in tickets) {
            val matchCount = ticket.countMatch(winningLotto)
            val hasBonus = bonusNumber in ticket.getNumbers()
            val rank = WinningRank.from(matchCount, hasBonus)
            result[rank] = result.getOrDefault(rank, 0) + 1
        }
        return WinningStats(result)
    }
}