package lotto

enum class Rank(val matchCount: Int, val bonusMatch: Boolean, val prize: Int) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000),
    NONE(0, false, 0);

    private fun matches(matchCount: Int, bonusMatch: Boolean): Boolean {
        if (needsBonusMatch()) {
            return this.matchCount == matchCount && this.bonusMatch == bonusMatch
        }
        return this.matchCount == matchCount
    }

    private fun needsBonusMatch() = this == SECOND || this == THIRD

    companion object {
        fun of(matchCount: Int, bonusMatch: Boolean): Rank {
            return entries.firstOrNull { it.matches(matchCount, bonusMatch) } ?: NONE
        }
    }
}
