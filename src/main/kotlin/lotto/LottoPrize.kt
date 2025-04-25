package lotto

enum class LottoPrize(
    val matches: String,
    val amount: Int,
    val value: Int,
) {

    THREE_MATCHES("3 Matches", 5_000, 3) {
        override fun isMatch(matchCount: Int, hasBonus: Boolean) = matchCount == value
    },
    FOUR_MATCHES("4 Matches", 50_000, 4) {
        override fun isMatch(matchCount: Int, hasBonus: Boolean) = matchCount == value
    },
    FIVE_MATCHES("5 Matches", 1_500_000, 5) {
        override fun isMatch(matchCount: Int, hasBonus: Boolean) = matchCount == value && !hasBonus
    },
    FIVE_MATCHES_BONUS("5 Matches + Bonus Ball", 30_000_000, 5) {
        override fun isMatch(matchCount: Int, hasBonus: Boolean) = matchCount == value && hasBonus
    },
    SIX_MATCHES("6 Matches", 2_000_000_000, 6) {
        override fun isMatch(matchCount: Int, hasBonus: Boolean) = matchCount == value
    };

    abstract fun isMatch(matchCount: Int, hasBonus: Boolean): Boolean
}
