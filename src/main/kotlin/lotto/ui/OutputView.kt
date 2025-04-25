package lotto.ui

import lotto.domain.WinningRank
import lotto.domain.PurchasedLottos
import lotto.domain.WinningStats
import lotto.util.Constants

class OutputView {
    companion object{
        fun printPurchasedLottos(purchasedLottos: PurchasedLottos) {
            val ticketAmount = purchasedLottos.count()
            println("\nYou have purchased $ticketAmount tickets.")
            purchasedLottos.getAllTickets().forEach{ticket->
                println(ticket)
            }
        }

        fun printWinningStats(winningStats: WinningStats){
            println("\nWinning Statistics")
            println("---")
            WinningRank.entries
                .filter { it != WinningRank.MISS }
                .sortedByDescending { it.prize }
                .forEach{ rank->
                    val count = winningStats.stats.getOrDefault(rank, 0)
                    val matchDescription = when (rank) {
                        WinningRank.FIFTH -> "3 Matches (${Constants.FORMATTED_PRIZE_FIFTH} KRW)"
                        WinningRank.FOURTH -> "4 Matches (${Constants.FORMATTED_PRIZE_FOURTH} KRW)"
                        WinningRank.THIRD -> "5 Matches (${Constants.FORMATTED_PRIZE_THIRD} KRW)"
                        WinningRank.SECOND -> "5 Matches + Bonus Ball (${Constants.FORMATTED_PRIZE_SECOND} KRW)"
                        WinningRank.FIRST -> "6 Matches (${Constants.FORMATTED_PRIZE_FIRST} KRW)"
                        else -> ""
                    }
                    println("$matchDescription - $count tickets")
                }
        }

        fun printProfitRate(winningStats: WinningStats, purchaseAmount: Int) {
            val totalPrize = winningStats.stats.entries.sumOf { (rank,count)->
                rank.prize * count
            }
            val profitRate = (totalPrize.toDouble()/purchaseAmount)*100
            println("Total return rate is ${profitRate}%.")
        }
    }
}