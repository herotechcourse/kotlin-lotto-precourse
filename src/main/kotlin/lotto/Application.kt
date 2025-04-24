package lotto

fun main() {
    // TODO: Implement the program
    // First input read and checked
    println(LottoMessages.welcome)
    val initiateLotto = InputView()
    val budget = initiateLotto.readBudget()
    val numberOfTickets = budget / 1000

    // Tickets created and checked
    val ticketCreator = TicketGenerator()
    val ticketsList = ticketCreator.generateMultiples(numberOfTickets)
    val ticketsOutput = OutputView()
    ticketsOutput.printPurchasedTickets(numberOfTickets, ticketsList)


    //Second input read and checked
    println(LottoMessages.winningNumbers)
    val winningNumbers = InputView()
    val readWinningNumbers = winningNumbers.readWinningNumbers()

}
