package lotto.controller.response.statistics

import lotto.domain.dto.PrizeResultDto

data class StatisticsDto(val resultDtos: List<PrizeResultDto>, val profitRate: Float) {
}