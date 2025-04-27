package lotto

class LottoResults {
    private val results = mutableMapOf(
        LottoRanks.MATCH_3.code to 0,
        LottoRanks.MATCH_4.code to 0,
        LottoRanks.MATCH_5.code to 0,
        LottoRanks.MATCH_5_AND_BONUS.code to 0,
        LottoRanks.MATCH_6.code to 0,
    )

    fun increaseMatchResult(rank: LottoRanks) {
        results[rank.code] = results[rank.code]!! + 1
    }

    fun getMatchResult(rank: LottoRanks): Int {
        return results[rank.code]!!
    }

    fun countReturnRate(purchaseAmount: Int): Double {
        var sumOfProfit = 0;
        for (rank in LottoRanks.entries) {
            sumOfProfit += results[rank.code]!! * rank.prize
        }
        return sumOfProfit.toDouble() * 100 / purchaseAmount
    }
}