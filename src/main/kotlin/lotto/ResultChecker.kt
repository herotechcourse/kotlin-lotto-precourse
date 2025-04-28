package lotto

class ResultChecker(private val winningNumbers: List<Int>, private val bonusNumber: Int) {
    fun checkResults(tickets: List<Lotto>): List<LottoResult> {
        return tickets.map { ticket ->
            val matchCount = countMatches(ticket)
            val bonusMatched = isBonusMatched(ticket)
            val prize = calculatePrize(matchCount, bonusMatched)
            LottoResult(ticket, matchCount, bonusMatched, prize)
        }
    }

    private fun countMatches(ticket: Lotto): Int {
        return ticket.getNumbers().count { it in winningNumbers }
    }

    private fun isBonusMatched(ticket: Lotto): Boolean {
        return ticket.getNumbers().contains(bonusNumber)
    }

    private fun calculatePrize(matchCount: Int, bonusMatched: Boolean): Prize {
        return when (matchCount) {
            6 -> Prize.FIRST
            5 -> if (bonusMatched) Prize.SECOND else Prize.THIRD
            4 -> Prize.FOURTH
            3 -> Prize.FIFTH
            else -> Prize.NONE
        }
    }

}