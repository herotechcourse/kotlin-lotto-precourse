package lotto.service

import lotto.Lotto
import lotto.core.BonusNumber
import lotto.core.Rank
import lotto.core.WinningNumbers

class ResultAnalyzer {
    fun analyze(
        tickets: List<Lotto>,
        winning: WinningNumbers,
        bonus: BonusNumber
    ): Map<Rank, Int> {
        val stats = Rank.entries.associateWith { 0 }.toMutableMap()
        for (ticket in tickets) {
            val matches = ticket.countMatching(winning.getNumbers())
            val hasBonus = ticket.hasBonus(bonus.value)
            Rank.of(matches, hasBonus)?.let { stats[it] = stats.getValue(it) + 1 }
        }
        return stats
    }
}