package lotto

fun getMoneyTicketsAndPrinter(): Triple<MoneyInput, TicketCreator, PrintingFunctionalityClass>
{
    val inputtingMoney = MoneyInput()
    val ticketCreation = TicketCreator()
    val printer = PrintingFunctionalityClass()

    return Triple(inputtingMoney, ticketCreation, printer)
}

fun getWinnings(): Pair<TakeWinningNumbers, StatisticsProvider>
{
    val inputtingNumbers = TakeWinningNumbers()
    val statistics = StatisticsProvider()

    return Pair (inputtingNumbers, statistics)
}

fun runProgramLogic(inputtingMoney: MoneyInput, ticketCreation: TicketCreator, printer: PrintingFunctionalityClass, inputtingNumbers: TakeWinningNumbers, statistics: StatisticsProvider)
{
    val moneySpent = inputtingMoney.inputMoneyAmount()
    val lottoTickets = ticketCreation.createTickets(moneySpent)
    printer.printLottoTickets(lottoTickets)
    val victoriousNumbers = inputtingNumbers.inputSixNumbersAndBonus()
    val bonus = victoriousNumbers.removeLast();
    val finalStatistics = statistics.provideStatistics(lottoTickets, victoriousNumbers, bonus, moneySpent)
    printer.printFinalResults (finalStatistics)
}

fun main()
{
    val (inputtingMoney, ticketCreation, printer) = getMoneyTicketsAndPrinter()
    val (inputtingNumbers, statistics) = getWinnings()
    runProgramLogic(inputtingMoney, ticketCreation, printer, inputtingNumbers, statistics)
}
