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
        for (prize in Prize.entries) {
            print("${prize.matchCount} Matches ")
            if (prize == Prize.SECOND)
                print("+ Bonus Ball ")
            println("${prize.prize} KRW) — ${prizeCount.getOrDefault(prize, 0)} tickets")
        }
    }

//    fun printProfitRate() {
//
//    }
}