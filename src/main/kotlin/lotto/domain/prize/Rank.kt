package lotto.domain.prize

enum class Rank(
    private val winningStrategy: WinningStrategy,
    private val prizeAmount: Int
) {
    FIFTH(MatchCountStrategy(3), 5_000),
    FOURTH(MatchCountStrategy(4), 50_000),
    THIRD(MatchCountAndBonusStrategy(5, false), 1_500_000),
    SECOND(MatchCountAndBonusStrategy(5, true), 30_000_000),
    FIRST(MatchCountStrategy(6), 2_000_000_000),
    NONE(MatchCountStrategy(0), 0);

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

    companion object {
        fun find(matchCount: Int, bonusMatch: Boolean): Rank {
            return entries.find { it.winningStrategy.matches(matchCount, bonusMatch) } ?: NONE
        }
    }
}