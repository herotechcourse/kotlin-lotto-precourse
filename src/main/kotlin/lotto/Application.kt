package lotto

fun calculateMatchResult(ticket: Lotto, winningNumbers: List<Int>, bonusNumber: Int): MatchResult {
    val matchCount = ticket.getNumbers().count { it in winningNumbers }
    val bonusMatched = ticket.getNumbers().contains(bonusNumber)
    return MatchResult(matchCount, bonusMatched)
}

fun calculatePrizeRanks(tickets: List<Lotto>, winningNumbers: List<Int>, bonusNumber: Int): List<PrizeRank> {
    return tickets.map { ticket ->
        val matchResult = calculateMatchResult(ticket, winningNumbers, bonusNumber)
        PrizeRank.from(matchResult.matchCount, matchResult.bonusMatched)
    }
}

fun main() {
    val inputView = InputView()
    val outputView = OutputView()

    val purchaseAmount = inputView.readPurchaseAmount()
    val tickets = LottoFactory.createMultipleTickets(purchaseAmount)
    outputView.printTickets(tickets)
    val winningNumbers = inputView.readWinningNumbers()
    val bonusNumber = inputView.readBonusNumber(winningNumbers)
    calculatePrizeRanks(tickets, winningNumbers, bonusNumber)
    println("Winning Statistics")
    println("---")

}
