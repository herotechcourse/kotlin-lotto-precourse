package lotto

enum class Rank(val prize: Int) {
    FIRST(LottoConstants.FIRST_PRIZE),
    SECOND(LottoConstants.SECOND_PRIZE),
    THIRD(LottoConstants.THIRD_PRIZE),
    FOURTH(LottoConstants.FOURTH_PRIZE),
    FIFTH(LottoConstants.FIFTH_PRIZE),
    NONE(LottoConstants.NONE_PRIZE);

    companion object {
        fun from(matchCount: Int, hasBonus: Boolean): Rank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && hasBonus -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> NONE
            }
        }
    }
}