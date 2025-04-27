package lotto.util

import lotto.LottoResultType

object LottoResultCalculator {

    fun countResultType(lottoResultTypes: List<LottoResultType>, targetType: LottoResultType): Int {
        return lottoResultTypes.count { lottoResultType -> lottoResultType == targetType }
    }

    fun calculateReturnRate(lottoResultTypes: List<LottoResultType>, amount: Int): Double {
        return calculate(lottoResultTypes).toDouble() / (amount * 1000) * 100
    }

    private fun calculate(lottoResultTypes: List<LottoResultType>): Int {
        var totalValue = 0
        for (lottoResultType in lottoResultTypes) {
            totalValue += lottoResultType.value
        }
        return totalValue
    }

}