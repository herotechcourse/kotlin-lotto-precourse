package lotto

class OutputHandler {
    fun printTicketNumber(count:Int){
        println("You have purchased $count tickets.")
    }

    fun printTickets(tickets: List<Lotto>){
        tickets.forEach { ticket ->
            println(ticket.getNumbers())
        }

    }

    fun printStatistics(statistics: Statistics) {
        println("\nWinning Statistics")
        println("---")
        println("3 Matches (5,000 KRW) - ${statistics.rankCounts[Rank.FIFTH]} ticket")
        println("4 Matches (50,000 KRW) - ${statistics.rankCounts[Rank.FOURTH]} ticket")
        println("5 Matches (1,500,000 KRW) - ${statistics.rankCounts[Rank.THIRD]} ticket")
        println("5 Matches + Bonus Ball (30,000,000 KRW) - ${statistics.rankCounts[Rank.SECOND]} ticket")
        println("6 Matches (2,000,000,000 KRW) - ${statistics.rankCounts[Rank.FIRST]} ticket")
        println("Total return rate is ${statistics.profitRate}%.")
    }
}