package lotto

class WinningNumbers(private val numbers: List<Int>, private val bonusNumber: Int) {

    fun match(ticket: LottoTicket): MatchResult {
        val matchCount = ticket.numbers.count { it in numbers }
        val hasBonus = bonusNumber in ticket.numbers
        return MatchResult(matchCount, hasBonus)
    }
}

data class MatchResult(val matchCount: Int, val hasBonus: Boolean)
