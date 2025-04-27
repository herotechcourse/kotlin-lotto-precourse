package lotto.service

import lotto.model.*
import lotto.util.RandomUtil

object LottoService {

    fun purchaseTickets(amount: Int): LottoTickets {
        val count = amount / 1000
        val tickets = List(count) { Lotto(RandomUtil.pickUniqueNumbers()) }
        return LottoTickets(tickets)
    }

    fun calculateResult(
        tickets: LottoTickets,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): Map<Rank, Int> {
        val winning = WinningNumbers(winningNumbers, bonusNumber)
        val results = mutableMapOf<Rank, Int>()

        tickets.getTickets().forEach { lotto ->
            val matchCount = winning.match(lotto)
            val bonusMatch = winning.isBonusMatch(lotto)
            val rank = Rank.from(matchCount, bonusMatch)
            results[rank] = results.getOrDefault(rank, 0) + 1
        }
        return results
    }
}
