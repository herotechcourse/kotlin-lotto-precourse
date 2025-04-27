package lotto.domain

enum class Rank(val matchCount: Int, val prize: Int, val requiresBonus: Boolean) {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000, false),
    FIFTH(3, 5_000, false);

    companion object {
        fun findByMatch(matchCount: Int, bonusMatch: Boolean): Rank? {
            return values().find { it.matchCount == matchCount && it.requiresBonus == bonusMatch }
                ?: values().find { it.matchCount == matchCount && !it.requiresBonus }
        }
    }
}
