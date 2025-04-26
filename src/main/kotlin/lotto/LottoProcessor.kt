package lotto

import camp.nextstep.edu.missionutils.Randoms

class LottoProcessor {
    fun ticketGenerator(purchaseAmount: Int): List<Lotto> {
        val ticketCount = purchaseAmount / 1000

        return List(ticketCount) {
            Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6))
        }
    }

    fun prizeCalculator(tickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Map<Prize, Int> {
        val prizeCategories = mutableMapOf<Prize, Int>()

        tickets.forEach { ticket ->
            val (matchedCount, bonusMatch) = ticket.matchingNumberCount(winningNumbers, bonusNumber)
            val prize = Prize.prizeFinder(matchedCount, bonusMatch)
            prizeCategories[prize] = prizeCategories.getOrDefault(prize, 0) + 1
        }

        return prizeCategories
    }

    fun profitRateCalculator(totalSpent: Int, prizeCategory: Map<Prize, Int>): Double {
        val totalPrizeAmount = prizeCategory.entries.sumOf { (rank, count) -> count * rank.prizeValue }

        // is 0 tickets a valid input?!
        if (totalSpent == 0) {
            return 0.0
        }

        return (totalPrizeAmount.toDouble() / totalSpent) * 100
    }
}