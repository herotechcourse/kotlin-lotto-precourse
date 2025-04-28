package lotto

class OutputView {
    fun displayTickets(tickets: List<Ticket>) {
        println()
        println("You have purchased ${tickets.size} tickets.")
        for (ticket in tickets) {
            print("[")
            print(ticket.sortedNumbers.joinToString(", "))
            println("]")
        }
    }

    fun printStatistics(prizeCount: Map<Prize, Int>) {
        println("\nWinning Statistics")
        println("-------------------")
        for (prize in Prize.entries.asReversed()) {
            if (prize == Prize.NONE)
                continue
            print("${prize.matchCount} Matches ")
            if (prize == Prize.SECOND)
                print("+ Bonus Ball ")
            println("(${prize.money} KRW) — ${prizeCount.getOrDefault(prize, 0)} tickets")
        }
    }

    fun printReturnRate(returnRate: Double) {
        println("Total return rate is %.1f".format(returnRate))
    }
}