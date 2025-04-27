package lotto.model

enum class Prize(val prize: Int, val output: String) {
    MISS(0, output = "0 Matches (0 KRW)"),
    FIFTH(5_000, output = "3 Matches (5,000 KRW)"),
    FOURTH(50_000, output = "4 Matches (50,000 KRW)"),
    THIRD(1_500_000, output = "5 Matches (1,500,000 KRW)"),
    SECOND(30_000_000, output = "5 Matches + Bonus Ball (30,000,000 KRW)"),
    FIRST(2_000_000_000, output = "6 Matches (2,000,000,000 KRW)");

    companion object {
        fun of(matchCount: Int, bonusMatch: Boolean): Prize {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && bonusMatch -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> MISS
            }
        }
    }
}