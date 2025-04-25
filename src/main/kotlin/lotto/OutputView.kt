package lotto

class OutputView {

    fun printTickets(tickets: List<Lotto>) {
        tickets.forEach { ticket ->
            println("[${ticket.getNumbers().joinToString(", ")}]")
        }
    }

    fun printWinners(winners: Map<LottoTicketCategory, Int>) {
        println("\nWinning Statistics\n---")
        LottoTicketCategory.values().forEach { category ->
            val count = winners[category] ?: 0
            if(category.prize.toInt() != 0)
                println("${category.message} – $count tickets")
        }
    }

    fun printReturnRate(totalEarn: Long, amountOfTickets: Long) {
        val returnRate = (totalEarn.toDouble() / amountOfTickets) * 100
        println("Total return rate is %.1f%%.".format(returnRate))
    }
}
