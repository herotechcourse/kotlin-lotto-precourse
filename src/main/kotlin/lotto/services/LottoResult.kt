package lotto.services

import lotto.Lotto

class LottoResult(
    val tickets: List<Lotto>,
    private val winningNumbers: Lotto,
    private val bonusNumber: Int
) {
    private val result = mutableMapOf<Prize, Int>()

    init {
        calculateResults()
    }

    private fun calculateResults() {
        for (ticket in tickets) {
            val matchCount = ticket.matchCount(winningNumbers)
            val hasBonus = ticket.contains(bonusNumber)

            val prize = Prize.of(matchCount, hasBonus)
            if (prize != null) {
                result[prize] = result.getOrDefault(prize, 0) + 1
            }
        }
    }

    fun getResult(): Map<Prize, Int> = result

    fun getTotalEarnings(): Long {
        return result.entries.sumOf { (prize, count) -> prize.prizeMoney * count }
    }

    fun getProfitRate(purchaseAmount: Int): Double {
        return (getTotalEarnings().toDouble() / purchaseAmount) * 100
    }
}
