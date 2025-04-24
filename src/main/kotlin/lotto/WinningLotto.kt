package lotto

class WinningLotto(private val winningNumbers: List<Int>, private val bonus: Int) {
    fun rankOf(ticket: Lotto): Rank {
        val matchCount = ticket.matchCount(winningNumbers)
        val hasBonus = ticket.containsBonus(bonus)
        return Rank.from(matchCount, hasBonus)
    }
}
