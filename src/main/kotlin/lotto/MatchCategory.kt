package lotto

enum class MatchCategory(val prizeAmount: Int, val displayName: String) {
    THREE_MATCHES(5_000, "3 Matches"),
    FOUR_MATCHES(50_000, "4 Matches"),
    FIVE_MATCHES(1_500_000, "5 Matches"),
    FIVE_MATCHES_AND_BONUS(30_000_000, "5 Matches + Bonus Ball"),
    SIX_MATCHES(2_000_000_000, "6 Matches")
}
