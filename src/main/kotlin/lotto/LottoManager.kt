package lotto

import kotlin.math.round

object LottoManager {
    private val tickets = mutableListOf<Lotto>()
    private val rankTable = MutableList(Rank.entries.size) { 0 }

    fun getTickets(): List<Lotto> = tickets.toList()

    fun getRankTable(): List<Int> = rankTable.toList()

    fun addTicket(ticket: Lotto) {
        tickets.add(ticket)
    }

    fun makeRankTable(winningNumbers: Lotto, bonusNumber: Int) {
        tickets.forEach {
            val rank = it.calculateRank(winningNumbers, bonusNumber)
            rankTable[rank.ordinal] += 1
        }
    }

    fun returnRate(purchaseAmount: Int): Double {
        val rawRate = totalPrize().toDouble() / purchaseAmount * 100
        val roundedRate = round(rawRate * 10) / 10.0
        return roundedRate
    }

    private fun totalPrize(): Long =
        Rank.entries
            .filterNot { it != Rank.ZERO }
            .sumOf { rank -> rankTable[rank.ordinal] * rank.prize }

    /**
     * Resets internal tickets and rank counts for testing purposes.
     */
    internal fun clear() {
        tickets.clear()
        for (i in rankTable.indices) {
            rankTable[i] = 0
        }
    }
}