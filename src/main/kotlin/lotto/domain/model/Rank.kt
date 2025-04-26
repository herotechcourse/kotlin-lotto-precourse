package lotto.domain.model

enum class Rank(val prize: Int) {
  FIRST(2_000_000_000),
  SECOND(30_000_000),
  THIRD(1_500_000),
  FOURTH(50_000),
  FIFTH(5_000),
  NONE(0);

  companion object {
    fun from(matchResult: MatchResult): Rank {
      return when {
        matchResult.matchCount == 6 -> FIRST
        matchResult.matchCount == 5 && matchResult.bonusMatch -> SECOND
        matchResult.matchCount == 5 -> THIRD
        matchResult.matchCount == 4 -> FOURTH
        matchResult.matchCount == 3 -> FIFTH
        else -> NONE
      }
    }
  }
}
