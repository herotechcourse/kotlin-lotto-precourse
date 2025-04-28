package lotto.ui

import lotto.domain.WinningRank
import lotto.domain.PurchasedLottos
import lotto.domain.WinningStats
import lotto.ui.console.ConsoleIOInterface
import lotto.util.Constants

class OutputView(private val console: ConsoleIOInterface) {
    fun printPurchasedLottos(purchasedLottos: PurchasedLottos) {
        val ticketAmount = purchasedLottos.count()
        console.print("\nYou have purchased $ticketAmount tickets.")
        purchasedLottos.getAllTickets().forEach { ticket ->
            console.print(ticket.toString())
        }
    }

    fun printWinningStats(winningStats: WinningStats) {
        console.print("\nWinning Statistics")
        console.print("---")
        WinningRank.entries
            .filter { it != WinningRank.MISS }
            .sortedBy { it.prize }
            .forEach { rank ->
                val count = winningStats.stats.getOrDefault(rank, 0)
                val matchDescription = getMatchDescription(rank)
                console.print("$matchDescription – $count tickets")
            }
    }

    private fun getMatchDescription(rank: WinningRank): String {
        val matchDescription = when (rank) {
            WinningRank.FIFTH -> "3 Matches (${Constants.FORMATTED_PRIZE_FIFTH} ${Constants.CURRENCY_UNIT})"
            WinningRank.FOURTH -> "4 Matches (${Constants.FORMATTED_PRIZE_FOURTH} ${Constants.CURRENCY_UNIT})"
            WinningRank.THIRD -> "5 Matches (${Constants.FORMATTED_PRIZE_THIRD} ${Constants.CURRENCY_UNIT})"
            WinningRank.SECOND -> "5 Matches + Bonus Ball (${Constants.FORMATTED_PRIZE_SECOND} ${Constants.CURRENCY_UNIT})"
            WinningRank.FIRST -> "6 Matches (${Constants.FORMATTED_PRIZE_FIRST} ${Constants.CURRENCY_UNIT})"
            else -> ""
        }
        return matchDescription
    }

    fun printProfitRate(winningStats: WinningStats, purchaseAmount: Int) {
        val totalPrize = winningStats.stats.entries.sumOf { (rank, count) ->
            rank.prize * count
        }
        val profitRate = (totalPrize.toDouble() / purchaseAmount) * 100
        console.print("Total return rate is ${profitRate}%.")
    }

}