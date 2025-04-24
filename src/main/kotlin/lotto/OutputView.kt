package lotto

class OutputView {

    fun displayPurchasedTickets(tickets: List<Lotto>) {
        println()
        Messages.display(Messages.TICKETS_PURCHASED, tickets.size)
        tickets.forEach { ticket ->
            println(convertTicketToString(ticket))
        }
        println()
    }

    private fun convertTicketToString(ticket: Lotto): String {
        val ticketNumbers = ticket.getNumbers()
        return ticketNumbers.joinToString(
            Messages.SEPARATOR,
            Messages.PREFIX,
            Messages.POSTFIX
        )
    }
}