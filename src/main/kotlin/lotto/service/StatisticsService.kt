package lotto.service

import lotto.domain.LottoResult
import kotlin.math.round

/**
 * Service class responsible for calculating statistics related to the lotto results.
 * Specifically, this includes calculating the return rate based on the total amount spent and the total amount won.
 */
object StatisticsService {
    /**
     * Calculates the return rate based on the total winnings from the provided lotto results and the total amount spent.
     * The return rate is calculated as the percentage of the total winnings over the total spend.
     * The result is rounded to one decimal place.
     */
    fun calculateReturnRate(lottoResults: List<LottoResult>, totalSpend: Int): Double {
        val totalWon = lottoResults.sumOf { it.totalPrizeMoney() }
        val rawRate = if (totalSpend == 0) 0.0 else (totalWon.toDouble() / totalSpend) * 100
        return roundToOneDecimal(rawRate)
    }

    /**
     * Rounds the given value to one decimal place.
     */
    private fun roundToOneDecimal(value: Double) = round(value * 10) / 10.0
}