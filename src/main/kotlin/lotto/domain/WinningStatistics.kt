package lotto.domain

import lotto.Lotto

object WinningStatistics {

    private val rankCounts: MutableMap<Rank, Int> = mutableMapOf()

    //TODO: find bug and fix
    fun get(playerData: PlayerData, winningLotto: Lotto, bonusNumber: Int) {
        playerData.rankResults = getRankDetails(playerData, winningLotto, bonusNumber)
    }

    private fun getRankDetails(playerData: PlayerData, winningLotto: Lotto, bonusNumber: Int): Map<Rank, Pair<Int, Int>> {
        val rankingTable = mutableMapOf<Rank, Pair<Int, Int>>() // each Rank -> (matching tickets, prize money)
        for (ticket in playerData.lottoTickets) {
            rankTicket(ticket, winningLotto, bonusNumber,rankingTable)
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


