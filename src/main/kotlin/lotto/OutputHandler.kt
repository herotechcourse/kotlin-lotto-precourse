package lotto

class OutputHandler {
    fun printTickets(ticketCount: Int, tickets: List<Lotto>) {
        println("\nYou have purchased $ticketCount tickets.")
        tickets.forEach { ticket ->
            println(ticket.getNumbers())
        }
    }

    fun printResults(results: List<LottoResult>) {
        val prizeCount = mutableMapOf<Prize, Int>().apply {
            Prize.entries.forEach { put(it, 0) }
        }

        results.forEach { result ->
            prizeCount[result.prize] = prizeCount.getValue(result.prize) + 1
        }

        prizeCount.forEach { (prize, count) ->
            if (count > 0) {
                println("\n${prize.name} (${prize.amount} KRW) – $count tickets")
            }
        }
    }

    fun printReturnRate(results: List<LottoResult>, ticketCount: Int) {
        val totalWinnings = results.sumOf { it.prize.amount }
        val returnRate = (totalWinnings.toDouble() / (ticketCount * 1000)) * 100
        println("Total return rate is %.1f%%.".format(returnRate))
    }

}