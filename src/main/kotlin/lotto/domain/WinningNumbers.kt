import lotto.Lotto
import lotto.domain.PrizeCategory

class WinningNumbers(private val numbers: List<Int>, private val bonus: Int) {

    fun match(ticket: Lotto): PrizeCategory {
        val matchCount = ticket.getNumbers().count { it in numbers }
        val bonusMatch = bonus in ticket.getNumbers()
        return PrizeCategory.getPrize(matchCount, bonusMatch)
    }
}
