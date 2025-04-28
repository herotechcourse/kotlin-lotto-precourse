package lotto

class OutputHandler {
    fun printTicketNumber(count: Int) {
        println("You have purchased $count tickets.")
    }

    fun printTickets(tickets: List<Lotto>) {
        tickets.forEach { ticket ->
            println(ticket.getNumbers().joinToString(", ", "[", "]"))
        }
    }

    fun printStatistics(statistics: Statistics) {
        println("\nLotto result statistics:")
        println("3 Matches (5,000 KRW) – ${statistics.getCount(Rank.FIFTH)} tickets")
        println("4 Matches (50,000 KRW) – ${statistics.getCount(Rank.FOURTH)} tickets")
        println("5 Matches (1,500,000 KRW) – ${statistics.getCount(Rank.THIRD)} tickets")
        println("5 Matches + Bonus Ball (30,000,000 KRW) – ${statistics.getCount(Rank.SECOND)} tickets")
        println("6 Matches (2,000,000,000 KRW) – ${statistics.getCount(Rank.FIRST)} tickets")
        println("Total return rate is ${statistics.profitRate}%.")
    }
}