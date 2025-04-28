package lotto

import kotlin.math.round

class LottoResult(private val result: MutableMap<LottoPrize, Int>, private val profitRate: Float) {
    fun getResult() = this.result

    fun getProfitRate() = this.profitRate

    companion object {
        fun from(lottoList: List<Lotto>, winningNumber: WinningNumber, bonusNumber: BonusNumber): LottoResult {
            val resultMap = mutableMapOf<LottoPrize, Int>().apply {
                LottoPrize.entries.forEach { put(it, 0) }
            }
            val lottoResult = LottoResult(resultMap)
            lottoList.forEach { lotto ->
                val matchCount = lotto.getNumbers().count { it in winningNumber.getNumbers() }
                val isBonusNumberMatched = lotto.getNumbers().contains(bonusNumber.getNumbers())
                lottoResult.calculateRank(matchCount, isBonusNumberMatched)
            }
            return lottoResult
        }
    }

    enum class LottoPrize(val matchCount: Int, val message: String, val prize: Int) {
        PRIZE_5TH(3, "3 Matches", 5000),
        PRIZE_4TH(4, "4 Matches", 50000),
        PRIZE_3RD(5, "5 Matches", 1500000),
        PRIZE_2ND(5, "5 Matches + Bonus Ball", 30000000),
        PRIZE_1ST(6, "6 Matches", 2000000000),
        ;
    }
}
