package lotto

fun main() {
    Application().run()
}

class Application {
    fun run() {
        val amount = InputView.readPurchaseAmount()
        val count = amount / 1000
        val tickets = TicketMachine.issueTickets(count)
        OutputView.printTickets(tickets)

        val winningNumbers = InputView.readWinningNumbers()
        val bonusNumber = InputView.readBonusNumber(winningNumbers)

        val result = LottoResult.calculate(tickets, winningNumbers, bonusNumber)
        OutputView.printStatistics(result, amount)
    }
}
