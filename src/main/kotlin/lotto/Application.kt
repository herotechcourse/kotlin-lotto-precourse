package lotto

class Application {
    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val amount = InputView.readPurchaseAmount()
            val ticketCount = amount / 1000
            val tickets = LottoMachine.createTickets(ticketCount)
            OutputView.printTickets(tickets)

            val winningNumbers = InputView.readWinningNumbers()
            val bonusNumber = InputView.readBonusNumber()
            val winning = WinningNumbers(winningNumbers, bonusNumber)

            val results = LottoResult.evaluate(tickets, winning)
            OutputView.printResults(results, amount)
        }
    }
}
