package lotto.service

import lotto.Lotto
import lotto.domain.Rank
import lotto.domain.WinningNumbers

class LottoGameService {

    fun evaluateTickets(tickets: List<Lotto>, winning: WinningNumbers): Map<Rank, Int> {
        val result = mutableMapOf<Rank, Int>()

        for (ticket in tickets) {
            val matchCount = ticket.countMatching(winning.getMainNumbers())
            val hasBonus = ticket.contains(winning.getBonus())

            val rank = Rank.from(matchCount, hasBonus)
            result[rank] = result.getOrDefault(rank, 0) + 1
        }

        return result
    }
}