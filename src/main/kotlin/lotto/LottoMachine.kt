package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoMachine {
    // Generates random tickets based on purchase amount
    fun generateTickets(amount: Int): List<Lotto> {
        val ticketCount = amount / 1000
        return List(ticketCount) {
            Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        }
    }

    // Calculates results for all tickets
    fun calculateResults(tickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<LottoRank, Int> {
        return tickets.map { it.getRank(winningNumbers, bonusNumber) }
            .groupingBy { it }
            .eachCount()
    }

    // Calculates return rate
    fun calculateReturnRate(results: Map<LottoRank, Int>, purchaseAmount: Int): Double {
        val totalPrize = results.entries.sumOf { (rank, count) -> rank.prize * count }
        return (totalPrize.toDouble() / purchaseAmount) * 100
    }
} 