package lotto.domain.dto

data class PrizeResultDto(
    val matchCount: Int,
    val bonusMatch: Boolean,
    val prizeAmount: Long,
    val count: Int
)
