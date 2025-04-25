package lotto.domain

class LottoProfitCalculator(
    private val results: LottoResults,
    private val purchaseAmount: Int
) {
    fun calculateProfitRate(): Double {
        val totalReward = Prize.valuesForResult().sumOf { prize ->
            prize.amount.toLong() * results.countOf(prize)
        }
        return totalReward.toDouble() / purchaseAmount
    }
}
