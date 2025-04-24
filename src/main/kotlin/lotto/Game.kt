package lotto

object Game {
    fun run() {
        val tickets = purchaseTickets()
        OutputView.displayTickets(tickets)
        val (winningNumbers, bonusNumber) = readWinningNumbers()
        val result = calculateResults(tickets, winningNumbers, bonusNumber)
        OutputView.displayResults(result)
    }

    private fun purchaseTickets(): List<Lotto> {
        val amount = InputView.purchaseAmount()
        val ticketCount = amount / 1000
        return List(ticketCount) { GeneratorTickets.generate() }
    }

    private fun readWinningNumbers(): Pair<List<Int>, Int> {
        val winningNumbers = InputView.winningNumbers()
        val bonusNumber = InputView.bonusNumber(winningNumbers)
        return winningNumbers to bonusNumber
    }

    private fun calculateResults(tickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): Result {
        val winner = WinnerTickets(winningNumbers, bonusNumber)
        val result = Result()
        tickets.forEach { ticket ->
            val rank = winner.getRank(ticket)
            result.add(rank)
        }
        return result
    }
}