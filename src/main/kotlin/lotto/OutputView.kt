package lotto

object OutputView {
    fun printTickets(tickets: List<List<Int>>, ticketNumber: Int) {
        println()
        println("You have purchased $ticketNumber tickets.")
        for (ticket in tickets) {
            if (ticket.isNotEmpty()) println(ticket)
        }
        println()
    }

    fun printPrize(rate: Double, prizeMap: Map<Prize, Int>) {
        println()
        println("Winning Statistics")
        println("---")
        printPrizeMap(prizeMap)

        println("Total return rate is %.1f%%.".format(rate))
    }

    private fun printPrizeMap(prizeMap: Map<Prize, Int>) {
        for (prize in prizeMap) {
            if (prize.key.bonus) {
                println("${prize.key.numberOfMatches} Matches + " + "Bonus Ball (${String.format("%,d", 
                            prize.key.prizeMoney)} KRW) – ${prize.value} tickets")
            } else {
                println("${prize.key.numberOfMatches} Matches " +
                        "(${String.format("%,d", prize.key.prizeMoney)} KRW) – ${prize.value} tickets")
            }
        }
    }
}