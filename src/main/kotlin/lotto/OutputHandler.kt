package lotto

class OutputHandler {
    fun printTickets(ticketCount: Int, tickets: List<Lotto>) {
        println("\nYou have purchased $ticketCount tickets.")
        tickets.forEach { ticket ->
            println(ticket.getNumbers())
        }
    }

    fun printResults(results: List<LottoResult>) {
        println("\nWinning Statistics\n---")
        val prizeCount = mutableMapOf<Prize, Int>().apply {
            Prize.entries.filter { it != Prize.NONE }.forEach { put(it, 0) }
        }

        results.forEach { result ->
            if (result.prize != Prize.NONE) {
                prizeCount[result.prize] = prizeCount.getValue(result.prize) + 1
            }
        }

        prizeCount.forEach { (prize, count) ->
            println("${prize.displayName} (${prize.amount} KRW) - $count tickets")
        }
    }


    fun printReturnRate(results: List<LottoResult>, ticketCount: Int) {
        val totalSpent = ticketCount * 1000
        if (totalSpent == 0) {
            println("Total return rate is 0.0%.")
            return
        }
        val totalWinnings = results.sumOf { it.prize.amount }
        val returnRate = (totalWinnings.toDouble() / totalSpent) * 100
        println("Total return rate is %.1f%%.".format(returnRate))
    }


}