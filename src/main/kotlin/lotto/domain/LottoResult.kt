package lotto.domain

import java.util.Locale

enum class Prize(val matchCount: Int, val hasBonus: Boolean, val amount: Int) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    companion object {
        fun from(matchCount: Int, hasBonus: Boolean): Prize {
            return values().find { it.matchCount == matchCount && it.hasBonus == hasBonus } ?: NONE
        }
    }
}

class LottoResult private constructor(val results: Map<Prize, Int>) {
    companion object {
        fun from(tickets: List<LottoTicket>, winningNumbers: WinningNumbers): LottoResult {
            val results = mutableMapOf<Prize, Int>()
            tickets.forEach { ticket ->
                val matches = ticket.countMatches(winningNumbers.numbers)
                val hasBonus = ticket.hasBonusNumber(winningNumbers.bonusNumber)
                val prize = Prize.from(matches, hasBonus)
                results[prize] = (results[prize] ?: 0) + 1
            }
            return LottoResult(results)
        }
    }

    fun calculateTotalPrize(): Int {
        return results.entries.sumOf { (prize, count) -> prize.amount * count }
    }

    fun calculateReturnRate(purchaseAmount: Int): String {
        val totalPrize = calculateTotalPrize()
        val rate = (totalPrize.toDouble() / purchaseAmount * 100)
        return if (rate % 1 == 0.0) {
            rate.toInt().toString()
        } else {
            String.format(Locale.US, "%.1f", rate)
        }
    }
} 