package lotto

object OutputView {
    fun printTickets(tickets: List<List<Int>>) {
        println()
        println("You have purchased ${tickets.size} tickets.")
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
        prizeMap.forEach { (prize, count) ->
            var prizeText = "${prize.numberOfMatches} Matches"
            if (prize.bonus)
                prizeText += " + Bonus Ball"
            val prizeMoneyText = String.format("%,d", prize.prizeMoney)
            println("$prizeText ($prizeMoneyText KRW) – $count tickets")
        }
    }

}