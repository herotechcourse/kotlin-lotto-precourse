package lotto.domain

enum class Rank (val matchCount: Int, val hasBonus: Boolean, val prize: Int) {
    FIRST(6, false, 2000000000),
    SECOND(5, true, 30000000),
    THIRD(5, false, 1500000),
    FOURTH(4, false, 50000),
    FIFTH(3, false, 5000),
    MISS(0, false, 0);

    companion object {
        fun determine(matchCount: Int, bonusMatched: Boolean): Rank {
            if (matchCount == 6) return FIRST
            if (matchCount == 5 && bonusMatched) return SECOND
            if (matchCount == 5) return THIRD
            if (matchCount == 4) return FOURTH
            if (matchCount == 3) return FIFTH
            return MISS
        }
    }

    fun getDescription(): String {
        if (matchCount == 5 && hasBonus) {
            return "5 Matches + Bonus Ball"
        }
        return "$matchCount Matches"
    }
}