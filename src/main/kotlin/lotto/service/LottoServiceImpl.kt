package lotto.service

import lotto.Lotto
import lotto.model.*
import lotto.util.RandomUtil

class LottoServiceImpl : LottoService {

    override fun purchaseTickets(amount: Int): LottoTickets {
        val count = amount / 1000
        val tickets = List(count) { Lotto(RandomUtil.pickUniqueNumbers()) }
        return LottoTickets(tickets)
    }

    override fun calculateResult(
        tickets: LottoTickets,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): Map<Rank, Int> {
        val winning = WinningNumbers(winningNumbers, bonusNumber)
        val results = Rank.initialResult()

        tickets.getTickets().forEach { lotto ->
            val matchCount = winning.match(lotto)
            val bonusMatch = winning.isBonusMatch(lotto)
            val rank = Rank.from(matchCount, bonusMatch)

            if (rank != Rank.NONE) {
                results[rank] = results.getValue(rank) + 1
            }
        }
        return results
    }
}
