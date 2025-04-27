package lotto

import lotto.PrizeRanking.*

class LotteryResults {
    fun getRank(matchCount: Int, hasBonus: Boolean): Long {
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

    fun getStatisticsMap(matchCount: List<Int>): Map<Int, Int> {
        val statisticsMap = mutableMapOf<Int, Int>()

        for (match in matchCount) {
            statisticsMap[match] = statisticsMap.getOrDefault(match, 0) + 1
        }

        return statisticsMap
    }

    fun getStatistics(tickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): List<String>{
        val matchCount = tickets.map{
                ticket -> ticket.getMatchingNumbers(winningNumbers)
        }
        val hasBonusList = tickets.map{
                ticket -> ticket.hasBonusNumber(bonusNumber)
        }

        val results = LotteryResults()
        val stats = results.getStatisticsMap(matchCount)
        var stat = mutableListOf<String>()
        stats.entries.zip(hasBonusList).forEach { (statMap, hasBonus) ->
            val (match, value) = statMap

            if (match >= 3) {
                val rank = results.getRank(match, hasBonus)
                val prize = results.formatPrize(rank)
                if (match == 5 && hasBonus)
                    stat.add("$match Matches + Bonus Ball ($prize KRW) - $value tickets")
                else {
                    stat.add("$match Matches ($prize KRW) - $value tickets")
                }
            }
        }
        return stat
    }

    fun formatPrize(number: Long): String{
        val formatter = java.text.DecimalFormat("#,###")
        return formatter.format(number)
    }
}