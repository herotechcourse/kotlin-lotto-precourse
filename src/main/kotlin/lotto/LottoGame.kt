package lotto

class LottoGame {
    fun run() {
        val amount = InputView.readPurchaseAmount()  // InputView should be imported here
        val ticketCount = amount / 1000
        OutputView.printTicketCount(ticketCount)
        val tickets = LottoMachine.generateTickets(ticketCount)
        OutputView.printTickets(tickets)

        val winningNumbers = InputView.readWinningNumbers()
        val bonusNumber = InputView.readBonusNumber(winningNumbers)

        val ranks = tickets.map { ticket ->
            val matchCount = ticket.countMatches(winningNumbers)
            val bonusMatched = ticket.containsBonus(bonusNumber)
            Rank.from(matchCount, bonusMatched)
        }

        OutputView.printResult(ranks, amount)
    }
}
