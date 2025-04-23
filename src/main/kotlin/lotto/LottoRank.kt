package lotto


enum class LottoRank(
    val matchCount: Int,
    val isBonus: Boolean = false,
    val prize: Int,
    val description: String
) {
    MISS(0, false, 0, "No prize"),
    FIFTH(3, false, PRIZE_FIFTH, LottoRankFormatter.formatDescription(3, false, PRIZE_FIFTH)),
    FOURTH(4, false, PRIZE_FOURTH, LottoRankFormatter.formatDescription(4, false, PRIZE_FOURTH)),
    THIRD(5, false, PRIZE_THIRD, LottoRankFormatter.formatDescription(5, false, PRIZE_THIRD)),
    SECOND(5, true, PRIZE_SECOND, LottoRankFormatter.formatDescription(5, true, PRIZE_SECOND)),
    FIRST(6, false, PRIZE_FIRST, LottoRankFormatter.formatDescription(6, false, PRIZE_FIRST));

    companion object {
        fun from(matchCount: Int, isBonus: Boolean): LottoRank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && isBonus -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> MISS
            }
        }
    }
}