package lotto.service

import lotto.domain.LottoResult
import kotlin.math.round

object StatisticsService {
    fun calculateReturnRate(lottoResults: List<LottoResult>, totalSpend: Int): Double {
        val totalWon = lottoResults.sumOf { it.totalPrizeMoney() }
        val rawRate = if (totalSpend == 0) 0.0 else (totalWon.toDouble() / totalSpend) * 100
        return roundToOneDecimal(rawRate)
    }

    private fun roundToOneDecimal(value: Double) = round(value * 10) / 10.0
}