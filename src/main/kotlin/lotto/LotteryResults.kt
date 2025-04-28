package lotto

import lotto.PrizeRanking.*

class LotteryResults {
    private var totalPrizeAmount: Long = 0

    internal fun getRank(matchCount: Int, hasBonus: Boolean): Long {
        if (matchCount == 6)
            return FIRST.prize
        if (matchCount == 5 && hasBonus)
            return SECOND.prize
        if (matchCount == 5)
            return THIRD.prize
        if (matchCount == 4)
            return FOURTH.prize
        return if (matchCount == 3)
            FIFTH.prize
        else
            NONE.prize
    }

    fun calculatePrizeStatistics(tickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): List<String> {
        val matchResults = tickets.map { ticket ->
            MatchResult(
                matchCount = ticket.getMatchingNumbers(winningNumbers),
                hasBonus = ticket.hasBonusNumber(bonusNumber)
            )
        }

        val winningMatchCounts = matchResults
            .filter { it.matchCount >= 3 }
            .groupBy { it.matchCount }
            .mapValues { it.value.size }

        totalPrizeAmount = calculateTotalPrize(winningMatchCounts, matchResults)

        return buildList {
            add(formatWinningStatistic(3, winningMatchCounts.getOrDefault(3, 0), false))
            add(formatWinningStatistic(4, winningMatchCounts.getOrDefault(4, 0), false))
            val fiveMatchesOnly = matchResults.count { it.matchCount == 5 && !it.hasBonus }
            val fiveMatchesWithBonus = matchResults.count { it.matchCount == 5 && it.hasBonus }
            add(formatWinningStatistic(5, fiveMatchesOnly, false))
            add(formatWinningStatistic(5, fiveMatchesWithBonus, true))
            add(formatWinningStatistic(6, winningMatchCounts.getOrDefault(6, 0), false))
        }
    }

    private fun formatWinningStatistic(matchCount: Int, count: Int, hasBonus: Boolean): String {
        val prize = formatPrize(getRank(matchCount, hasBonus))
        val matchDescription = if (matchCount == 5 && hasBonus) {
            "$matchCount Matches + Bonus Ball"
        } else {
            "$matchCount Matches"
        }
        return "$matchDescription ($prize KRW) – $count tickets"
    }

    private fun calculateTotalPrize(
        statisticsMap: Map<Int, Int>,
        matchResults: List<MatchResult>
    ): Long = statisticsMap.entries.sumOf { (matchCount, count) ->
        val hasBonus = matchResults.any { it.matchCount == matchCount && it.hasBonus }
        getRank(matchCount, hasBonus) * count
    }

    fun calculateReturnRate(purchaseAmount: Int): String{
        val percentage = totalPrizeAmount.toDouble() / purchaseAmount.toDouble() * 100
        return String.format("%.1f", percentage)
    }

    private fun formatPrize(number: Long): String =
        String.format("%,d", number)

    data class MatchResult(
        val matchCount: Int,
        val hasBonus: Boolean
    )
}
