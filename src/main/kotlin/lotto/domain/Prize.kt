package lotto.domain

enum class Prize(val matchCount: Int, val bonusMatch: Boolean, val reward: Int) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    companion object {
        fun of(matchCount: Int, bonus: Boolean): Prize {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && bonus -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> NONE
            }
        }
    }

    fun description(): String {
        return when (this) {
            FIRST -> "6 Matches (2,000,000,000 KRW)"
            SECOND -> "5 Matches + Bonus Ball (30,000,000 KRW)"
            THIRD -> "5 Matches (1,500,000 KRW)"
            FOURTH -> "4 Matches (50,000 KRW)"
            FIFTH -> "3 Matches (5,000 KRW)"
            NONE -> ""
        }
    }
}
