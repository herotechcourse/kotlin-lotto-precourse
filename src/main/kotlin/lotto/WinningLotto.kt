package lotto

class WinningLotto(
    private val winningNumbers: List<Int>,
    private val bonusNumber: Int
) {
    fun match(ticket: LottoTicket): Rank {
        val matchedCount = ticket.lotto.getNumbers().count { it in winningNumbers }
        val bonusMatch = bonusNumber in ticket.lotto.getNumbers()
        return Rank.of(matchedCount, bonusMatch)
    }
}
