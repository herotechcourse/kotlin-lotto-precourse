package lotto

private val output = OutputView()

class LottoMachine {
    enum class PrizeRank(val prize: Int, val description: String) {
        Rank1(2000000000, "6 Matches (2,000,000,000 KRW)"),
        Rank2(30000000, "5 Matches + Bonus Ball (30,000,000 KRW)"),
        Rank3(1500000, "5 Matches (1,500,000 KRW)"),
        Rank4(50000, "4 Matches (50,000 KRW)"),
        Rank5(5000, "3 Matches (5,000 KRW)"),
        None(0, "");

        companion object {
            fun of(matchCount: Int, hasBonus: Boolean): PrizeRank {
                return when {
                    matchCount == 6 -> Rank1
                    matchCount == 5 && hasBonus -> Rank2
                    matchCount == 5 -> Rank3
                    matchCount == 4 -> Rank4
                    matchCount == 3 -> Rank5
                    else -> None
                }
            }
        }
    }

    fun MatchNumbers(bonusNumber: Int, tickets: List<List<Int>>, winningNumbers: List<Int>): Int {
        var totalPrize = 0
        val rankStats = mutableMapOf<PrizeRank, Int>()

        for (ticket in tickets) {
            val matchCount = ticket.count { it in winningNumbers }
            val hasBonus = bonusNumber in ticket

            // Get prize rank based on match count and bonus
            val prizeRank = PrizeRank.of(matchCount, hasBonus)

            // Count how many tickets won this specific rank
            rankStats[prizeRank] = rankStats.getOrDefault(prizeRank, 0) + 1

            // Accumulate total prize money
            totalPrize += prizeRank.prize

        }
        output.PrintPrizeRanks(rankStats)
        return totalPrize
    }

    fun ProfitCalculation(totalPrize: Int, purchaseAmount: Int): Double {
        val profit = totalPrize.toDouble() / purchaseAmount.toDouble() * 100
        return profit
    }
}