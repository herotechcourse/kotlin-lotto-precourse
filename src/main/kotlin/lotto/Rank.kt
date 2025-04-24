package lotto

enum class Rank(val matchCount: Int, val bonusMatch: Boolean, val prize: Int) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    fun description(): String = when (this) {
        FIRST -> "6 Matches (2,000,000,000 KRW)"
        SECOND -> "5 Matches + Bonus Ball (30,000,000 KRW)"
        THIRD -> "5 Matches (1,500,000 KRW)"
        FOURTH -> "4 Matches (50,000 KRW)"
        FIFTH -> "3 Matches (5,000 KRW)"
        NONE -> ""
    }

    companion object {
        fun from(count: Int, hasBonus: Boolean): Rank = when {
            count == 6 -> FIRST
            count == 5 && hasBonus -> SECOND
            count == 5 -> THIRD
            count == 4 -> FOURTH
            count == 3 -> FIFTH
            else -> NONE
        }
    }
}
