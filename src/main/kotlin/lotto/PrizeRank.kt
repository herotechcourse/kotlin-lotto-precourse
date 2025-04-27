package lotto

enum class PrizeRank(val matchCount: Int, val matchBonus: Boolean, val prize: Int) {
  FIRST(6, false, 2_000_000_000),
  SECOND(5, true, 30_000_000),
  THIRD(5, false, 1_500_000),
  FOURTH(4, false, 50_000),
  FIFTH(3, false, 5_000),
  NONE(0, false, 0);

  companion object {
    fun valueOf(matchCount: Int, matchBonus: Boolean): PrizeRank {
      return when {
        matchCount == 6 -> FIRST
        matchCount == 5 && matchBonus -> SECOND
        matchCount == 5 -> THIRD
        matchCount == 4 -> FOURTH
        matchCount == 3 -> FIFTH
        else -> NONE
      }
    }
  }
}