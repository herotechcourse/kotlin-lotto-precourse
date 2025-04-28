package lotto.view

import lotto.controller.response.statistics.StatisticsDto
import lotto.domain.dto.PrizeResultDto

object PrintFormatter {
    fun formatResultMessage(resultDto: PrizeResultDto): String {
        return String.format(determineFormat(resultDto), resultDto.matchCount, resultDto.prizeAmount, resultDto.count)
    }

    private fun determineFormat(prizeResultDto: PrizeResultDto): String {
        if (!prizeResultDto.bonusMatch) {
            return WINNING_WITH_ONLY_MATCHES
        }
        return WINNING_WITH_BONUS_BALL
    }

    fun formatProfitRateMessage(statisticsDto: StatisticsDto): String {
        return String.format(TOTAL_RETURN_RATE, statisticsDto.profitRate)
    }

    private const val WINNING_WITH_ONLY_MATCHES: String = "%d Matches (%,d KRW) – %d tickets"
    private const val WINNING_WITH_BONUS_BALL: String = "%d Matches + Bonus Ball (%,d KRW) – %d tickets"
    private const val TOTAL_RETURN_RATE: String = "Total return rate is %,.1f%%."
}