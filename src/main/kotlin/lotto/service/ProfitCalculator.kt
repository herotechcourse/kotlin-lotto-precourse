package lotto.service

import lotto.core.Rank
import lotto.core.constant.LottoConstants.HUNDRED
import lotto.core.constant.LottoConstants.LOTTO_PRICE


class ProfitCalculator {
    fun calculate(stats: Map<Rank, Int>, purchaseAmount: Int): Double {
        val totalReturn = stats.entries.sumOf { (rank, count) -> rank.prize * count }.run { this / LOTTO_PRICE }
        return ((totalReturn.toDouble() / purchaseAmount) * HUNDRED)
    }
}