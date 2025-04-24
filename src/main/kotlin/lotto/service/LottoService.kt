package lotto.service

import lotto.Lotto
import lotto.domain.LottoTicket
import lotto.domain.Rank
import lotto.util.RandomUtil

class LottoService {

    fun generateTickets(purchaseAmount: Int): List<LottoTicket> {
        val numberOfTickets = purchaseAmount / 1000
        return List(numberOfTickets) { createTicket() }
    }

    private fun createTicket(): LottoTicket {
        val lotto = Lotto(RandomUtil.generateRandomNumbers())
        return LottoTicket(lotto)
    }

    fun evaluateResults(
        tickets: List<LottoTicket>,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): Map<Rank, Int> {
        return tickets.groupBy { evaluateTicket(it, winningNumbers, bonusNumber) }
            .mapValues { it.value.size }
    }

    private fun evaluateTicket(
        ticket: LottoTicket,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): Rank {
        val matchCount = ticket.matchCount(winningNumbers)
        val isBonusMatch = ticket.containsBonusNumber(bonusNumber)

        return when (matchCount) {
            6 -> Rank.FIRST
            5 -> if (isBonusMatch) Rank.SECOND else Rank.THIRD
            4 -> Rank.FOURTH
            3 -> Rank.FIFTH
            else -> Rank.NONE
        }
    }
}
