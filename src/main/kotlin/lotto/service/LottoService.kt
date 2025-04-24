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
        val rankCounts = Rank.entries.associateWith { 0 }.toMutableMap()

        tickets.forEach { ticket ->
            val rank = evaluateTicket(ticket, winningNumbers, bonusNumber)
            rankCounts[rank] = rankCounts.getValue(rank) + 1
        }

        return rankCounts
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

    fun calculateProfitRate(purchaseAmount: Int, results: Map<Rank, Int>): Double {
        val totalPrizeMoney = results.entries.sumOf { (rank, count) ->
            rank.prizeAmount * count
        }
        return calculateRate(purchaseAmount, totalPrizeMoney)
    }

    private fun calculateRate(purchaseAmount: Int, totalPrizeMoney: Long): Double {
        return if (purchaseAmount > 0) {
            (totalPrizeMoney.toDouble() / purchaseAmount) * 100
        } else {
            0.0
        }
    }


}
