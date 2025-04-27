package lotto.domain

import lotto.Lotto

object WinningStatistics {

    fun get(playerData: PlayerData, winningLotto: Lotto, bonusNumber: Int) {
        playerData.rankResults = getRankDetails(playerData, winningLotto, bonusNumber)
        playerData.prizeSum = calculateRankEarnings(playerData.rankResults)
        playerData.returnRate = calculateProfitRate(playerData.moneySpent, playerData.prizeSum)
    }

    private fun calculateRankEarnings(rankResults: Map<Rank, Pair<Int, Int>>): Int {
        var totalEarned = 0;
        for ((rank, pair) in rankResults) {
            val (ticketCount, prizeMoney) = pair
            val rankEarnings = ticketCount * prizeMoney
            totalEarned += rankEarnings
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
        winningLotto: Lotto,
        bonusNumber: Int
    ): Map<Rank, Pair<Int, Int>> {
        val rankingTable = mutableMapOf<Rank, Pair<Int, Int>>() // each Rank -> (matching tickets, prize money)
        for (rank in Rank.entries) {
            rankingTable[rank] = Pair(0, rank.prizeMoney)
        }

        for (ticket in playerData.lottoTickets) {
            rankTicket(ticket, winningLotto, bonusNumber, rankingTable)
        }
        return rankingTable
    }

    private fun rankTicket(
        ticket: Lotto,
        winningLotto: Lotto,
        bonusNumber: Int,
        rankingTable: MutableMap<Rank, Pair<Int, Int>>
    ) {
        val foundWinningNumbers = ticket.getNumbers().count { it in winningLotto.getNumbers() }
        val foundBonus = bonusNumber in ticket.getNumbers()
        val ticketRank = Rank.find(foundWinningNumbers, foundBonus)
        if (ticketRank != null) {
            val (matchingTickets, prizeMoney) = rankingTable.getOrDefault(ticketRank, Pair(0, ticketRank.prizeMoney))
            rankingTable[ticketRank] = Pair(matchingTickets + 1, prizeMoney)
        }
    }
}


