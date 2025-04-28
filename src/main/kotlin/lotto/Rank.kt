package lotto

import lotto.LottoConstants.LOTTO_FIFTH_PRIZE_AMOUNT
import lotto.LottoConstants.LOTTO_FIRST_PRIZE_AMOUNT
import lotto.LottoConstants.LOTTO_FOURTH_PRIZE_AMOUNT
import lotto.LottoConstants.LOTTO_NONE_PRIZE_AMOUNT
import lotto.LottoConstants.LOTTO_SECOND_PRIZE_AMOUNT
import lotto.LottoConstants.LOTTO_THIRD_PRIZE_AMOUNT

enum class Rank(
    val matchCount: Int,
    val prize: Int,
    val requireBonus: Boolean = false,
) {
    FIRST(6, LOTTO_FIRST_PRIZE_AMOUNT),
    SECOND(5, LOTTO_SECOND_PRIZE_AMOUNT, requireBonus = true),
    THIRD(5, LOTTO_THIRD_PRIZE_AMOUNT),
    FOURTH(4, LOTTO_FOURTH_PRIZE_AMOUNT),
    FIFTH(3, LOTTO_FIFTH_PRIZE_AMOUNT),
    NONE(-1, LOTTO_NONE_PRIZE_AMOUNT);

    companion object {
        fun from(matchCount: Int, matchBonus: Boolean): Rank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && matchBonus -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> NONE
            }
        }
    }
}