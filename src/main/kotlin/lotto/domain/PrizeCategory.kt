package lotto.domain

enum class PrizeCategory(val prizeAmount: Int, val description: String) {
    NONE(0, "No Matches"),
    THREE_MATCHES(5_000, "3 Matches"),
    FOUR_MATCHES(50_000, "4 Matches"),
    FIVE_MATCHES(1_500_000, "5 Matches"),
    FIVE_MATCHES_BONUS(30_000_000, "5 Matches + Bonus Ball"),
    SIX_MATCHES(2_000_000000, "6 Matches");



    companion object {
        fun getPrize(matchCount: Int, bonusMatch: Boolean): PrizeCategory {
            if (matchCount == 6) return SIX_MATCHES
            if (matchCount == 5 && bonusMatch) return FIVE_MATCHES_BONUS
            if (matchCount == 5) return FIVE_MATCHES
            if (matchCount == 4) return FOUR_MATCHES
            if (matchCount == 3) return THREE_MATCHES
            return NONE
        }
    }
}