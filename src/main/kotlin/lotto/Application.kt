package lotto

fun main() {
    val outputView = OutputView()
    val inputView = InputView()

    // TODO: Implement the program
    // First input read and checked
    outputView.printWelcomeMessage()
    val budget = inputView.readBudget()
    val numberOfTickets = budget / 1000

    // Tickets created, checked and printed
    val ticketCreator = TicketGenerator()
    val ticketsList = ticketCreator.generateMultiples(numberOfTickets)
    outputView.printPurchasedTickets(numberOfTickets, ticketsList)

    //Second input read and checked
    outputView.printWinningNumbersPrompt()
    val readWinningNumbers = inputView.readWinningNumbers()

    //Third input (Create a bonusNumber input)
    outputView.printBonusNumberPrompt()
    val readBonusNumber = inputView.readBonusNumber()

    //Logic to check for winnerTickets, match prizes and print
    outputView.printWinningStatisticsTitle()
    val ticketChecker = TicketChecker()
    val winningResults = ticketChecker.calculateTicketsResults(ticketsList, readWinningNumbers, readBonusNumber)
    outputView.printResults(winningResults)

    //Logic to check profit rate
    val profitCalculator = ProfitCalculator()
    val profitRate = profitCalculator.calculate(budget, winningResults)
    outputView.printProfitRate(profitRate)
}
