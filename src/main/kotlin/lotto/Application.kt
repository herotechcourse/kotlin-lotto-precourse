package lotto

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val amountOfTickets = inputView.getAmountOfTickets()
    println("\nYou have purchased ${amountOfTickets / 1000} tickets.")

    val tickets = inputView.generateTickets(amountOfTickets)
    outputView.printTickets(tickets)

    val winningNumbers = inputView.getWinningNumbers()
    val bonusNumber = inputView.getBonusNumber()

    val winners = mutableMapOf<LottoTicketCategory, Int>().apply {
        LottoTicketCategory.values().forEach { put(it, 0) }
    }
    var totalEarn = 0L

    tickets.forEach { ticket ->
        val category = ticket.compareTicket(winningNumbers, bonusNumber)
        winners[category] = winners[category]!! + 1
        totalEarn += category.prize
    }

    outputView.printWinners(winners)
    outputView.printReturnRate(totalEarn, amountOfTickets)
}
