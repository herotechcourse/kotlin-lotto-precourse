package lotto

class ResultChecker(private val winningNumbers: List<Int>, private val bonusNumber: Int) {
    fun checkResults(tickets: List<Lotto>): List<LottoResult> {
        return tickets.map { ticket ->
            val matchCount = ticket.getNumbers().count { it in winningNumbers }
            val bonusMatched = bonusNumber in ticket.getNumbers()
            val prize = Prize.from(matchCount, bonusMatched)
            LottoResult(ticket, matchCount, bonusMatched, prize)
        }
    }
}
