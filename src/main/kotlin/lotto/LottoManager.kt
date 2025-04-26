package lotto

import kotlin.math.round

object LottoManager {
    private val tickets = mutableListOf<Lotto>()
    private val rankTable = MutableList(Rank.entries.size) { 0 }

    fun addTicket(ticket: Lotto) {
        tickets.add(ticket)
    }

    fun makeRankTable(winningNumbers: Lotto, bonusNumber: Int) {
        tickets.forEach {
            val rank = it.calculateRank(winningNumbers, bonusNumber)
            rankTable[rank.ordinal] += 1
        }
    }

    fun printTickets() {
        tickets.forEach {
            it.printNumbers()
        }
    }

    private fun totalPrize(): Long =
        Rank.entries
            .filterNot { it != Rank.ZERO }
            .sumOf { rank -> rankTable[rank.ordinal] * rank.prize}

    fun printRankTable() {
        Rank.entries
            .filter {it != Rank.ZERO}
            .forEach { rank ->
                val count = rankTable[rank.ordinal]
                val prizeText = "%,d KRW".format(rank.prize)
                println("${rank.label} ($prizeText) - $count tickets")
            }
    }

    fun printReturnRate(purchaseAmount: Int) {
        val rawRate = totalPrize().toDouble() / purchaseAmount * 100
        val roundedRate = round(rawRate * 10) / 10.0
        val rateText = "%,.1f%%".format(roundedRate)
        println("Total return rate is $rateText.")
    }
}