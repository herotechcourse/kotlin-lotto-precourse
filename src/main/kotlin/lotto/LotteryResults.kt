package lotto

import lotto.PrizeRanking.*

class LotteryResults {
    private var sum: Long = 0

    internal fun getRank(matchCount: Int, hasBonus: Boolean): Long {
        if (matchCount == 6)
            return FIRST.prize
        if (matchCount == 5 && hasBonus)
            return SECOND.prize
        if (matchCount == 5)
            return THIRD.prize
        if (matchCount == 4)
            return FOURTH.prize
        if (matchCount == 3)
            return FIFTH.prize
        else
            return NONE.prize
    }

    fun getStatistics(tickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): List<String> {
        val matchResults = tickets.map { ticket ->
            MatchResult(
                matchCount = ticket.getMatchingNumbers(winningNumbers),
                hasBonus = ticket.hasBonusNumber(bonusNumber)
            )
        }

        val statisticsMap = matchResults
            .filter { it.matchCount >= 3 }
            .groupBy { it.matchCount }
            .mapValues { it.value.size }

        sum = calculateTotalPrize(statisticsMap, matchResults)

        return buildList {
            add(formatStatistic(3, statisticsMap.getOrDefault(3, 0), false))
            add(formatStatistic(4, statisticsMap.getOrDefault(4, 0), false))
            val fiveMatchesOnly = matchResults.count { it.matchCount == 5 && !it.hasBonus }
            val fiveMatchesWithBonus = matchResults.count { it.matchCount == 5 && it.hasBonus }
            add(formatStatistic(5, fiveMatchesOnly, false))
            add(formatStatistic(5, fiveMatchesWithBonus, true))
            add(formatStatistic(6, statisticsMap.getOrDefault(6, 0), false))
        }
    }

    private fun formatStatistic(matchCount: Int, count: Int, hasBonus: Boolean): String {
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
        val percentage = sum.toDouble() / purchaseAmount.toDouble() * 100
        return String.format("%.1f", percentage)
    }

    private fun formatPrize(number: Long): String =
        String.format("%,d", number)

    private data class MatchResult(
        val matchCount: Int,
        val hasBonus: Boolean
    )
}
