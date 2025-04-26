package lotto

import camp.nextstep.edu.missionutils.Randoms

object LottoMachine {
    data class LottoResult(val counts: Map<String, Int>, val profitRate: Double)

    private val prizeMap = mapOf(
        "3 Matches (5,000 KRW)" to 5000,
        "4 Matches (50,000 KRW)" to 50000,
        "5 Matches (1,500,000 KRW)" to 1500000,
        "5 Matches + Bonus Ball (30,000,000 KRW)" to 30000000,
        "6 Matches (2,000,000,000 KRW)" to 2000000000
    )

    fun generateTickets(purchaseAmount: Int): List<Lotto> {
        val ticketCount = purchaseAmount / 1000
        return List(ticketCount) {
            val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6).sorted()
            Lotto(numbers)
        }
    }

    fun calculateResults(
        tickets: List<Lotto>,
        winningNumbers: List<Int>,
        bonusNumber: Int
    ): LottoResult {
        val counts = mutableMapOf(
            "3 Matches (5,000 KRW)" to 0,
            "4 Matches (50,000 KRW)" to 0,
            "5 Matches (1,500,000 KRW)" to 0,
            "5 Matches + Bonus Ball (30,000,000 KRW)" to 0,
            "6 Matches (2,000,000,000 KRW)" to 0
        )

        for (ticket in tickets) {
            val matchCount = ticket.matchCount(winningNumbers)
            when (matchCount) {
                6 -> counts["6 Matches (2,000,000,000 KRW)"] = counts["6 Matches (2,000,000,000 KRW)"]!! + 1
                5 -> {
                    if (ticket.containsBonus(bonusNumber)) {
                        counts["5 Matches + Bonus Ball (30,000,000 KRW)"] = counts["5 Matches + Bonus Ball (30,000,000 KRW)"]!! + 1
                    } else {
                        counts["5 Matches (1,500,000 KRW)"] = counts["5 Matches (1,500,000 KRW)"]!! + 1
                    }
                }
                4 -> counts["4 Matches (50,000 KRW)"] = counts["4 Matches (50,000 KRW)"]!! + 1
                3 -> counts["3 Matches (5,000 KRW)"] = counts["3 Matches (5,000 KRW)"]!! + 1
            }
        }

        val totalPrize = counts.entries.sumOf { (key, count) ->
            prizeMap[key]!! * count
        }
        val totalSpent = tickets.size * 1000
        val rawRate = totalPrize.toDouble() / totalSpent * 100
        // Round profit rate to one decimal place
        val profitRate = String.format("%.1f", rawRate).toDouble()
        return LottoResult(counts, profitRate)
    }
}
