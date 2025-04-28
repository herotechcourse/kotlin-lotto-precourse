package lotto.controller.response

import lotto.domain.dto.PrizeResultDto

data class StatisticsDto(val resultDtos: List<PrizeResultDto>, val profitRate: Float) {
}