package lotto

object OutputFormatter {

    fun printTicketNumbers(tickets: List<Lotto>) {
        tickets.forEach { ticket ->
            println(ticket.getNumbers().sorted())
        }
    }

    fun printLottoStatistics(matches: Map<Rank, Int>, totalWinnings: Long, purchaseAmount: Int) {
        println()
        println("Winning Statistics")

        for (rank in Rank.entries.sortedBy { it.prizeAmount }) {
            if (rank == Rank.NONE) continue

            val count = matches[rank] ?: 0
            val bonusText = if (rank == Rank.SECOND) " + Bonus Ball" else ""
            println(
                "${rank.matchCount} Matches$bonusText (${
                    String.format(
                        "%,d",
                        rank.prizeAmount
                    )
                } KRW) – $count tickets"
            )
        }

        val returnRate = (totalWinnings.toDouble() / purchaseAmount) * 100
        println("Total return rate is ${"%.1f".format(returnRate)}%.")
    }
}
