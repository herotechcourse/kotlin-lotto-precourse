package lotto.model

import lotto.util.LottoConstants

enum class Rank(val prize: Double) {
    FIRST(LottoConstants.FIRST_PRIZE),
    SECOND(LottoConstants.SECOND_PRIZE),
    THIRD(LottoConstants.THIRD_PRIZE),
    FOURTH(LottoConstants.FOURTH_PRIZE),
    FIFTH(LottoConstants.FIFTH_PRIZE),
    NONE(LottoConstants.NONE_PRIZE);

    companion object {
        fun from(match: Int, bonus: Boolean) = when {
            match == 6 -> FIRST
            match == 5 && bonus -> SECOND
            match == 5 -> THIRD
            match == 4 -> FOURTH
            match == 3 -> FIFTH
            else -> NONE
        }
    }
}