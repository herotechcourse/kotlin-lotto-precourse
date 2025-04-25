package lotto.domain

class LottoProfitCalculator(
    private val results: LottoResults,
    private val purchaseAmount: Int
) {
    fun calculate(): ProfitRate {
        val totalReward = Prize.valuesForResult().sumOf { prize ->
            prize.amount.toLong() * results.countOf(prize)
        }
        val rate = totalReward.toDouble() / purchaseAmount
        return ProfitRate(rate)
    }
}

