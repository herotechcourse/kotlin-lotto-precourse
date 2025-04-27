package lotto

enum class Prize(val matchCount: Int, val prizeValue: Long, val description: String) {
    FIRST(6, 2_000_000_000, "6 Matches (2,000,000,000 KRW)"),
    SECOND(5, 30_000_000, "5 Matches + Bonus Ball (30,000,000 KRW)"),
    THIRD(5, 1_500_000, "5 Matches (1,500,000 KRW)"),
    FOURTH(4, 50_000, "4 Matches (50,000 KRW)"),
    FIFTH(3, 5_000, "3 Matches (5,000 KRW)"),
    NONE(0, 0, "No prize");

    companion object {
        fun prizeFinder(matchCount: Int, bonusMatch: Boolean): Prize {
            if (matchCount == 6) return FIRST
            if (matchCount == 5 && bonusMatch) return SECOND
            if (matchCount == 5) return THIRD
            if (matchCount == 4) return FOURTH
            if (matchCount == 3) return FIFTH
            return NONE
        }
    }
}
