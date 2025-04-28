package lotto.domain.prize

enum class Rank(
    private val winningStrategy: WinningStrategy,
    private val prizeAmount: Long
) {
    FIFTH(MatchCountStrategy(3), 5_000L),
    FOURTH(MatchCountStrategy(4), 50_000L),
    THIRD(MatchCountAndBonusStrategy(5, false), 1_500_000L),
    SECOND(MatchCountAndBonusStrategy(5, true), 30_000_000L),
    FIRST(MatchCountStrategy(6), 2_000_000_000L),
    NONE(MatchCountStrategy(0), 0L);

    private interface WinningStrategy {
        fun matches(matchCount: Int, bonusMatch: Boolean): Boolean
    }

    private class MatchCountStrategy(private val matchCount: Int) : WinningStrategy {
        override fun matches(matchCount: Int, bonusMatch: Boolean): Boolean {
            return matchCount == this.matchCount
        }
    }

    private class MatchCountAndBonusStrategy(private val matchCount: Int, private val bonusMath: Boolean) :
        WinningStrategy {
        override fun matches(matchCount: Int, bonusMatch: Boolean): Boolean {
            return this.matchCount == matchCount && this.bonusMath == bonusMatch
        }
    }

    fun multiplyPrizeAmount(count: Int): Long = prizeAmount * count

    companion object {
        fun find(matchCount: Int, bonusMatch: Boolean): Rank {
            return entries.find { it.winningStrategy.matches(matchCount, bonusMatch) } ?: NONE
        }
    }
}