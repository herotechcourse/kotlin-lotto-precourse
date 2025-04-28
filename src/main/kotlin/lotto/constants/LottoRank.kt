package lotto.constants

enum class LottoRank(val matchCount: Int, val prize: Long, val description: String, val order: Int) {
    SIX_MATCH(6, 2_000_000_000, "6 Matches (2,000,000,000 KRW)", 5),
    FIVE_MATCH_WITH_BONUS(5, 30_000_000, "5 Matches + Bonus Ball (30,000,000 KRW)", 4),
    FIVE_MATCH(5, 1_500_000, "5 Matches (1,500,000 KRW)", 3),
    FOUR_MATCH(4, 50_000, "4 Matches (50,000 KRW)", 2),
    THREE_MATCH(3, 5_000, "3 Matches (5,000 KRW)", 1),
    NONE(0, 0, "No Prize", 0);

    companion object {
        fun findRank(matchCount: Int, hasBonus: Boolean): LottoRank {
            return when {
                matchCount == 6 -> SIX_MATCH
                matchCount == 5 && hasBonus -> FIVE_MATCH_WITH_BONUS
                matchCount == 5 -> FIVE_MATCH
                matchCount == 4 -> FOUR_MATCH
                matchCount == 3 -> THREE_MATCH
                else -> NONE
            }
        }

        fun orderedRanks(): List<LottoRank> = entries
            .filter { it != NONE }
            .sortedBy { it.order }
    }
}