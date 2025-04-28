package lotto

import camp.nextstep.edu.missionutils.Randoms

fun createOneTicket(): Lotto {
    val numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
    return Lotto(numbers)
}

fun createMultipleTickets(ticketCount: Int): List<Lotto> {
    val lottoTickets = mutableListOf<Lotto>()
    repeat(ticketCount) {
        lottoTickets.add(createOneTicket())
    }
    return lottoTickets
}

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
    val purchaseAmount = inputView.readPurchaseAmount()
    println()
    val ticketCount = purchaseAmount / 1000
    println("You have purchased $ticketCount tickets.")
    val tickets = createMultipleTickets(ticketCount)
    for (ticket in tickets) {
        println(ticket)
    }
    println()

    val winningNumbers = inputView.readWinningNumbers()
    println()

    val bonusNumber = inputView.readBonusNumber(winningNumbers)
    println()

    calculatePrizeRanks(tickets, winningNumbers, bonusNumber)
    println("Winning Statistics")
    println("---")

}
