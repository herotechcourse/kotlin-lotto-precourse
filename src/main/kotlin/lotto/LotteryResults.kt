package lotto

import lotto.PrizeRanking.*

class LotteryResults {
    private var totalPrizeAmount: Long = 0

    // retrieves the prize based on match count and bonus status
    internal fun getRank(matchCount: Int, hasBonus: Boolean): Long {
        return when (matchCount) {
            6 -> FIRST.prize
            5 -> if (hasBonus) SECOND.prize else THIRD.prize
            4 -> FOURTH.prize
            3 -> FIFTH.prize
            else -> NONE.prize
        }
    }

    // calculate and format statistics for the lottery results
    fun calculatePrizeStatistics(tickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): List<String> {
        val matchResults = tickets.map { ticket ->
            MatchResult(
                matchCount = ticket.getMatchingNumbers(winningNumbers),
                hasBonus = ticket.hasBonusNumber(bonusNumber)
            )
        }

        val matchCountToTicketCount = matchResults
            .filter { it.matchCount >= 3 }
            .groupBy { it.matchCount }
            .mapValues { it.value.size }

        totalPrizeAmount = calculateTotalPrize(matchCountToTicketCount, matchResults)

        return buildList {
            add(formatWinningStatistic(3, matchCountToTicketCount.getOrDefault(3, 0), false))
            add(formatWinningStatistic(4, matchCountToTicketCount.getOrDefault(4, 0), false))
            val fiveMatchesOnly = matchResults.count { it.matchCount == 5 && !it.hasBonus }
            val fiveMatchesWithBonus = matchResults.count { it.matchCount == 5 && it.hasBonus }
            add(formatWinningStatistic(5, fiveMatchesOnly, false))
            add(formatWinningStatistic(5, fiveMatchesWithBonus, true))
            add(formatWinningStatistic(6, matchCountToTicketCount.getOrDefault(6, 0), false))
        }
    }

    // format the winning statistics
    private fun formatWinningStatistic(matchCount: Int, count: Int, hasBonus: Boolean): String {
        val prize = formatPrize(getRank(matchCount, hasBonus))
        val matchDescription = if (matchCount == 5 && hasBonus) {
            "$matchCount Matches + Bonus Ball"
        } else {
            "$matchCount Matches"
        }
        return "$matchDescription ($prize KRW) – $count tickets"
    }

    // calculate the total prize amount based on the match counts and the results
    private fun calculateTotalPrize(
        statisticsMap: Map<Int, Int>,
        matchResults: List<MatchResult>
    ): Long = statisticsMap.entries.sumOf { (matchCount, count) ->
        val hasBonus = matchResults.any { it.matchCount == matchCount && it.hasBonus }
        getRank(matchCount, hasBonus) * count
    }

    // calculate the return rate based on the purchase amount
    fun calculateReturnRate(purchaseAmount: Int): String{
        val percentage = totalPrizeAmount.toDouble() / purchaseAmount.toDouble() * 100
        return String.format("%.1f", percentage)
    }

    // format the prize amount with commas for readability
    private fun formatPrize(number: Long): String =
        String.format("%,d", number)

    // data class to store match results for each ticket
    data class MatchResult(
        val matchCount: Int,
        val hasBonus: Boolean
    )
}
