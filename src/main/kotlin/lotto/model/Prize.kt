package lotto.model

import lotto.common.ErrorMessages

class Prize(private val matchCount: Int, private val isMatchBonus: Boolean) {
    private val value: Rank

    init {
        require(matchCount >= 0) { ErrorMessages.INVALID_MATCH_COUNT_UNIT }
        value = formatValue(matchCount, isMatchBonus)
    }

    fun getRank(): Rank = value

    fun getReward(): Int = value.reward

    private fun formatValue(count: Int, isBonus: Boolean): Rank {
        return when {
            count == Rank.FIRST.matchCount -> Rank.FIRST
            count == Rank.SECOND.matchCount && isBonus -> Rank.SECOND
            count == Rank.THIRD.matchCount -> Rank.THIRD
            count == Rank.FOURTH.matchCount -> Rank.FOURTH
            count == Rank.FIFTH.matchCount -> Rank.FIFTH
            else -> Rank.NONE
        }
    }

}