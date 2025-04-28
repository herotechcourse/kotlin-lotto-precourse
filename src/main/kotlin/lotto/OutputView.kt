package lotto

object OutputView {
    fun printTickets(tickets: List<List<Int>>) {
        println("\nYou have purchased ${tickets.size} tickets.")
        for (ticket in tickets) {
           val sortedTicket = ticket.toSortedSet()
            if (sortedTicket.isNotEmpty())
                println(sortedTicket)
        }
    }

    fun printPrize(rate: Double, prizeMap: Map<Prize, Int>) {
        println("\nWinning Statistics")
        println("---")
        printPrizeMap(prizeMap)
        println("Total return rate is %.1f%%.".format(rate*100))
    }

    private fun printPrizeMap(prizeMap: Map<Prize, Int>) {
        prizeMap.forEach { (prize, count) ->
            var prizeText = "${prize.numberOfMatches} Matches"
            if (prize.hasBonus)
                prizeText += " + Bonus Ball"
            val prizeMoneyText = String.format("%,d", prize.money)
            println("$prizeText ($prizeMoneyText KRW) – $count tickets")
        }
    }

}