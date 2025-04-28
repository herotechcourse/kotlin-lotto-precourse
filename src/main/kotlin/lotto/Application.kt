package lotto

fun main() {
    val purchaseAmount = InputHandler.readAndValidatePurchaseAmount()
    val lottoMachine = LottoMachine(purchaseAmount)
    val ticketCount = lottoMachine.calculateTicketCount()
    val tickets = lottoMachine.generateTickets(ticketCount)

    val outputHandler = OutputHandler()
    outputHandler.printTickets(ticketCount, tickets)

    val winningNumbers = InputHandler.readAndValidateWinningNumbers()
    val bonusNumber = InputHandler.readAndValidateBonusNumber()

    val resultChecker = ResultChecker(winningNumbers, bonusNumber)
    val results = resultChecker.checkResults(tickets)
    println(results)

    outputHandler.printResults(results)
    outputHandler.printReturnRate(results, ticketCount)


}
