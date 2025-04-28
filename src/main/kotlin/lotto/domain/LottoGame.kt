package lotto.domain

import camp.nextstep.edu.missionutils.Randoms
import lotto.Lotto
import lotto.domain.PrizeRank

class LottoGame {
    companion object {
        private const val LOTTO_PRICE = 1000
        private const val MIN_NUMBER = 1
        private const val MAX_NUMBER = 45
        private const val NUMBERS_COUNT = 6
    }

    fun generateTickets(purchaseAmount: Int): List<Lotto> {
        val ticketCount = purchaseAmount / LOTTO_PRICE
        return List(ticketCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_COUNT)
            Lotto(numbers)
        }
    }

    fun calculateProfitRate(purchaseAmount: Int, results: Map<PrizeRank, Int>): Double {
        val totalPrize = results.entries.sumOf { (rank, count) -> rank.prizeAmount * count }
        return (totalPrize.toDouble() / purchaseAmount) * 100
    }

    fun calculateResults(tickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<PrizeRank, Int> {
        val results = mutableMapOf<PrizeRank, Int>()
        PrizeRank.entries.forEach { rank -> results[rank] = 0 }

        tickets.forEach { ticket ->
            val prize = ticket.determinePrize(winningNumbers, bonusNumber)
            results[prize] = results[prize]!! + 1
        }

        return results
    }
}