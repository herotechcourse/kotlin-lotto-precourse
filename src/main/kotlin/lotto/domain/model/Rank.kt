package lotto.domain.model

const val FIRST_PRIZE = 2_000_000_000
const val SECOND_PRIZE = 30_000_000
const val THIRD_PRIZE = 1_500_000
const val FOURTH_PRIZE = 50_000
const val FIFTH_PRIZE = 5_000
const val NONE_PRIZE = 0

enum class Rank(val prize: Int) {
  FIRST(FIRST_PRIZE),
  SECOND(SECOND_PRIZE),
  THIRD(THIRD_PRIZE),
  FOURTH(FOURTH_PRIZE),
  FIFTH(FIFTH_PRIZE),
  NONE(NONE_PRIZE);

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
