package lotto.service

import camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange
import lotto.Lotto
import lotto.model.Prize

class LottoService(private val winningNumbers: List<Int>, private val bonusNumber: Int) {

    fun verifyTicket(ticket: Lotto): Prize {
        val matchCount = winningNumbers.intersect(ticket.numbers).size
        val bonusMatch = ticket.numbers.contains(bonusNumber)

        return Prize.of(matchCount, bonusMatch)
    }

    fun getReturnRate(ranks: List<Prize>, purchaseAmount: Int): Double {
        val totalWinnings = ranks.sumOf { it.prize }
        return (totalWinnings.toDouble() / purchaseAmount) * 100
    }

    fun countRanks(ranks: List<Prize>) =
        Prize.entries.drop(1).associateWith { prize ->
            ranks.count { it == prize }
        }

    companion object {
        fun generateTickets(amount: Int): List<Lotto> {
            require(amount % 1000 == 0) { "[ERROR] Amount must be a multiple of 1,000." }

            val numberOfTickets = amount / 1000
            return List(size = numberOfTickets) {
                val numbers = pickUniqueNumbersInRange(1, 45, 6)
                Lotto(numbers)
            }
        }
    }
}