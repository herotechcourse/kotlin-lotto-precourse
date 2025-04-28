package lotto.domain

import lotto.util.Constants

enum class WinningRank(val prize: Int) {
    FIRST(Constants.PRIZE_FIRST),
    SECOND(Constants.PRIZE_SECOND),
    THIRD(Constants.PRIZE_THIRD),
    FOURTH(Constants.PRIZE_FOURTH),
    FIFTH(Constants.PRIZE_FIFTH),
    MISS(0);

    companion object {
        fun from(matchCount: Int, hasBonus: Boolean): WinningRank {
            return when (matchCount) {
                6 -> FIRST
                5 -> if (hasBonus) SECOND else THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> MISS
            }
        }
    }
}