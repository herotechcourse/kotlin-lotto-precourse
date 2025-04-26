package lotto

fun main() {
    // TODO: Implement the program
    // First input read and checked
    println(LottoMessages.welcome)
    val initiateLotto = InputView()
    val budget = initiateLotto.readBudget()
    val numberOfTickets = budget / 1000

    // Tickets created, checked and printed
    val ticketCreator = TicketGenerator()
    val ticketsList = ticketCreator.generateMultiples(numberOfTickets)
    println(ticketsList)
    val ticket = ticketCreator.generateTicket()
    val ticketsOutput = OutputView()
    ticketsOutput.printPurchasedTickets(numberOfTickets, ticketsList)

    //Second input read and checked
    println(LottoMessages.winningNumbers)
    val winningNumbers = InputView()
    val readWinningNumbers = winningNumbers.readWinningNumbers()

    //Third input (Create a bonusNumber input)
    println(LottoMessages.bonusNumber)
    val bonusNumber = InputView()
    val readBonusNumber = bonusNumber.readBonusNumber()

    //Logic to check for winnerTickets, and match with prizes
    println(LottoMessages.winningStatisticsTitle)
    println(LottoMessages.dashSeparator)

    val checkPrizes = TicketChecker()

    val prizeResults = checkPrizes.checkMultipleTickets(ticketsList, readWinningNumbers, readBonusNumber)
    println(prizeResults)
//    val resultsOutput = OutputView()
//    resultsOutput.printMatches(prizeResults)

    //Logic to check profit rate

}
