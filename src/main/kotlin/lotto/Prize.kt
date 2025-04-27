package lotto

enum class PrizeRank(
    val matchCount: Int, val bonusRequired: Boolean, val prize: Int, val rank: Int, val description: String
) {
    FIRST(
        6, false, 2_000_000_000, 1, "6 Matches (2,000,000,000 KRW)"
    ),
    SECOND(
        5, true, 30_000_000, 2, "5 Matches + Bonus Ball (30,000,000 KRW)"
    ),
    THIRD(
        5, false, 1_500_000, 3, "5 Matches (1,500,000 KRW)"
    ),
    FOURTH(
        4, false, 50_000, 4, "4 Matches (50,000 KRW)"
    ),
    FIFTH(
        3, false, 5_000, 5, "3 Matches (5,000 KRW)"
    );

    companion object {
        fun of(matchCount: Int, bonus: Boolean): PrizeRank? =
            PrizeRank.entries.firstOrNull { it.matchCount == matchCount && it.bonusRequired == bonus }
    }
}
