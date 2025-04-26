package lotto

import kotlin.math.round

class OutputView {
    fun printPurchasedTickets(tickets: List<Lotto>) {
        println()
        println("You have purchased ${tickets.size} tickets.")
        tickets.forEach { 
            println(it.getNumbers())
        }
        println()
    }

    fun printWinningStatistics(rankCounts: Map<Rank, Int>, totalPurchaseAmount: Int) {
        println("Winning Statistics")
        println("---")
        
        // Print each rank in order (except NONE)
        Rank.values().filter { it != Rank.NONE }.sortedByDescending { it.matchCount }
            .forEach { rank ->
                val count = rankCounts.getOrDefault(rank, 0)
                val prizeFormatted = String.format("%,d", rank.prizeMoney)
                println("${rank.matchCount} Matches${if (rank == Rank.SECOND) " + Bonus Ball" else ""} (${prizeFormatted} KRW) – ${count} tickets")
            }
        
        // Calculate return rate
        val totalPrize = rankCounts.entries.sumOf { (rank, count) -> rank.prizeMoney * count }
        val returnRate = totalPrize * 100.0 / totalPurchaseAmount
        val roundedReturnRate = round(returnRate * 10) / 10.0
        
        println("Total return rate is ${roundedReturnRate}%.")
    }
} 