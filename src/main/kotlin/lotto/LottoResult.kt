package lotto

import kotlin.math.round

class LottoResult(private val result: MutableMap<LottoPrize, Int>, private val profitRate: Float) {
    fun getResult() = this.result

    fun getProfitRate() = this.profitRate

    companion object {
        fun from(lottoList: List<Lotto>, winningNumber: WinningNumber, bonusNumber: BonusNumber): LottoResult {
            val resultMap = LottoPrize.entries.associateWith { 0 }.toMutableMap()

            lottoList.forEach { lotto ->
                val matchCount = countMatchedNumbers(lotto, winningNumber)
                val isBonusNumberMatched = isBonusMatched(lotto, bonusNumber)
                calculateRank(resultMap, matchCount, isBonusNumberMatched)
            }
            val profitRate = calculateProfitRate(resultMap, lottoList.size)
            return LottoResult(resultMap, profitRate)
        }

        private fun countMatchedNumbers(lotto: Lotto, winningNumber: WinningNumber): Int {
            return lotto.getNumbers().count { it in winningNumber.getNumbers() }
        }

        private fun isBonusMatched(lotto: Lotto, bonusNumber: BonusNumber): Boolean {
            return lotto.getNumbers().contains(bonusNumber.getNumber())
        }

        private fun calculateRank(
            resultMap: MutableMap<LottoPrize, Int>, matchCount: Int, isBonusNumberMatched: Boolean
        ) {
            val prize = when {
                matchCount == LottoPrize.PRIZE_2ND.matchCount && isBonusNumberMatched -> LottoPrize.PRIZE_2ND
                else -> LottoPrize.entries.find { it.matchCount == matchCount }
            }
            prize?.let { resultMap[it] = (resultMap[it] ?: 0) + 1 }
        }

        private fun calculateProfitRate(resultMap: MutableMap<LottoPrize, Int>, ticketCount: Int): Float {
            val prize = resultMap.entries.sumOf { (key, value) ->
                key.prize * value
            }
            return round((prize.toFloat() / (ticketCount * 1000) * 100) * 10) / 10f
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
