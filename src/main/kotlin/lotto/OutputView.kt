package lotto

class OutputView {

    fun displayPurchasedTickets(tickets: List<Lotto>) {
        println()
        Messages.display(Messages.TICKETS_PURCHASED, tickets.size)
        tickets.forEach { ticket ->
            println(convertTicketToString(ticket))
        }
    }

    private fun convertTicketToString(ticket: Lotto): String {
        val ticketNumbers = ticket.getNumbers()
        return ticketNumbers.joinToString(
            Messages.SEPARATOR,
            Messages.PREFIX,
            Messages.POSTFIX
        )
    }

    fun displayWinningStatistics(rankList: Map<Rank, Int>) {
        println()
        Messages.display(Messages.WINNING_STATISTICS)
        Messages.display(Messages.MATCH_SIX, rankList[Rank.FIRST] ?: 0)
        Messages.display(Messages.MATCH_FIVE_BONUS, rankList[Rank.SECOND] ?: 0)
        Messages.display(Messages.MATCH_FIVE, rankList[Rank.THIRD] ?: 0)
        Messages.display(Messages.MATCH_FOUR, rankList[Rank.FOURTH] ?: 0)
        Messages.display(Messages.MATCH_THREE, rankList[Rank.FIFTH] ?: 0)
    }

    fun displayReturnRate(percentage: Double) {
        Messages.display(Messages.RETURN_RATE, percentage)
    }
}