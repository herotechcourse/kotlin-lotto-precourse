package lotto

import java.util.Locale

enum class Rank(
    val matchCount: Int,
    val requiresBonus: Boolean,
    val prize: Int
) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0); // For tickets that don't win

    companion object {
        fun determineRank(matchCount: Int, isBonusMatched: Boolean): Rank {
            return entries.firstOrNull {
                it.matchCount == matchCount && it.requiresBonus == isBonusMatched
            } ?: if (matchCount >= 3) NONE else NONE
        }
    }
}

class ResultEvaluator(
    private val winningNumbers: Set<Int>,
    private val bonusNumber: Int
) {
    fun evaluate(tickets: List<Lotto>): Result {
        val rankCounts = mutableMapOf<Rank, Int>()
        var totalWinnings = 0

        for (ticket in tickets) {
            val matchCount = ticket.getNumbers().count { it in winningNumbers }
            val isBonusMatched = bonusNumber in ticket.getNumbers()

            val rank = Rank.determineRank(matchCount, isBonusMatched)
            rankCounts[rank] = rankCounts.getOrDefault(rank, 0) + 1
            totalWinnings += rank.prize
        }

        return Result(rankCounts, totalWinnings)
    }

    data class Result(
        val rankCounts: Map<Rank, Int>,
        val totalWinnings: Int
    ) {
        fun calculateProfitRate(purchaseAmount: Int): Double {
            return if (purchaseAmount > 0) {
                (totalWinnings.toDouble() / purchaseAmount) * 100
            } else {
                0.0
            }
        }

        fun displayStatistics(purchaseAmount: Int) {
            val profitRate = calculateProfitRate(purchaseAmount)
//            println("Winning Statistics")
//            println("---")
            Rank.entries
                .filter { it.matchCount >= 3 } // Include only ranks with matchCount >= 3
                .sortedWith(
                    compareBy(
                        { it.matchCount },
                        { !it.requiresBonus })
                ) // Sort by matchCount, then by bonus requirement
                .forEach { rank ->
                    println(
                        "${rank.matchCount} Matches${if (rank.requiresBonus) " + Bonus Ball" else ""} (${
                            "%,d".format(Locale.US,rank.prize)
                        } KRW) – ${
                            rankCounts.getOrDefault(rank, 0)
                        } tickets"
                    )
                }
            println("Total return rate is ${"%.1f".format(Locale.US,profitRate)}%.")
        }
    }
}

