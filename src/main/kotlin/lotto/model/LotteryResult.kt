package lotto.model

import lotto.LotteryConstants
import lotto.Lotto

class LotteryResult(private val tickets: List<Lotto>, private val winningLotto: WinningLotto) {
    private val totalPurchaseAmount = tickets.size * LotteryConstants.TICKET_PRIZE
    private val totalPrizeMoney: Long by lazy { calculateTotalPrizeMoney() }
    private val prizeTierMap: Map<PrizeTier, Int> by lazy { calculatePrizeTier() }

    private fun calculateTotalPrizeMoney(): Long {
        var prizeMoney = 0L

        tickets.forEach { ticket ->
            val prizeTier = winningLotto.match(ticket)
            prizeMoney += prizeTier.prizeMoney
        }

        return prizeMoney
    }

    private fun calculatePrizeTier(): Map<PrizeTier, Int> {
        val resultMap = mutableMapOf<PrizeTier, Int>()

        tickets.forEach { ticket ->
            val prizeTier = winningLotto.match(ticket)
            if (prizeTier != PrizeTier.NONE) {
                resultMap[prizeTier] = resultMap.getOrDefault(prizeTier, 0) + 1
            }
        }

        return resultMap
    }

    fun getPrizeTierCount(prizeTier: PrizeTier): Int {
        return prizeTierMap[prizeTier] ?: 0
    }

    fun getReturnRate(): Double {
        return totalPrizeMoney.toDouble() / totalPurchaseAmount * 100
    }

}