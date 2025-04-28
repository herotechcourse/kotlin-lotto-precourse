package lotto.domain

import lotto.Lotto

object WinningStatistics {

    fun get(playerData: PlayerData, winningSet: WinningSet) {
        playerData.rankResults = getRankDetails(playerData, winningSet)
        playerData.prizeSum = calculateRankEarnings(playerData.rankResults)
        playerData.returnRate = calculateProfitRate(playerData.moneySpent, playerData.prizeSum)
    }

    private fun calculateRankEarnings(rankResults: Map<Rank, Pair<Int, Int>>): Int {
        var totalEarned = 0
        for ((ticketCount, prizeMoney) in rankResults.values) {
            totalEarned += ticketCount * prizeMoney
        }
        return totalEarned
    }

    private fun calculateProfitRate(moneySpent: Int, totalPrize: Int): Double {
        if (moneySpent == 0)
            return 0.0
        return (totalPrize.toDouble() / moneySpent) * 100
    }

    private fun getRankDetails(
        playerData: PlayerData,
        winningSet: WinningSet   // ⚡️ Pass full winningSet here
    ): Map<Rank, Pair<Int, Int>> {
        val rankingTable = mutableMapOf<Rank, Pair<Int, Int>>()
        for (rank in Rank.entries) {
            rankingTable[rank] = Pair(0, rank.prizeMoney)
        }
        for (ticket in playerData.lottoTickets) {
            rankTicket(ticket, winningSet, rankingTable)
        }
        return rankingTable
    }

    private fun rankTicket(
        ticket: Lotto,
        winningSet: WinningSet,
        rankingTable: MutableMap<Rank, Pair<Int, Int>>
    ) {
        val ticketRank = winningSet.match(ticket)  // ✅ Now winningSet is available
        if (ticketRank != null) {
            val (matchingTickets, prizeMoney) = rankingTable.getOrDefault(ticketRank, Pair(0, ticketRank.prizeMoney))
            rankingTable[ticketRank] = Pair(matchingTickets + 1, prizeMoney)
        }
    }
}
