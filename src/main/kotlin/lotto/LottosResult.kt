package lotto

import lotto.enums.Rank
import lotto.utils.ResultCalculator

data class LottosResult(val lottos: Lottos, val winningNumbers: WinningNumbers) {
    val result: Map<String, Int>
        get() = ResultCalculator.calculateMatches(lottos, winningNumbers)

    fun calculateProfitRate(): String {
        val cost = lottos.getTickets().size * 1000
        val profit = totalPrize()
        val profitRate = (profit.toDouble() / cost) * 100
        return String.format("%.1f%%", profitRate)
    }

    fun totalPrize(): Int {
        var total = 0
        for (res in result) {
            val prize = when (res.key) {
                "3" -> Rank.THREE.prize
                "4" -> Rank.FOUR.prize
                "5" -> Rank.FIVE.prize
                "5+bonus" -> Rank.FIVE_BONUS.prize
                "6" -> Rank.SIX.prize
                else -> 0
            }
            total += res.value * prize
        }
        return total
    }
}

