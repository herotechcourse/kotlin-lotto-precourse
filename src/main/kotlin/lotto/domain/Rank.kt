package lotto.domain

enum class Rank(val matchCount: Int, val hasBonus: Boolean, val prize: Long) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    MISS(0, false, 0);

    companion object {
        fun of(matchCount: Int, bonusMath: Boolean): Rank {
            return entries.firstOrNull { it.matchCount == matchCount && it.hasBonus == bonusMath }
                ?: if (matchCount >= 3) {
                    entries.first { it.matchCount == matchCount && !it.hasBonus }
                } else {
                    MISS
                }
        }
    }
}