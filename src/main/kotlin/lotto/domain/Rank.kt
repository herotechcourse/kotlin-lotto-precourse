package lotto.domain

enum class Rank(val matchCount: Int, val hasBonus: Boolean, val prize: Int, val message: String) {
  FIRST(6, false, 2_000_000_000, "6 Matches (2,000,000,000 KRW)"),
  SECOND(5, true, 30_000_000, "5 Matches + Bonus Ball (30,000,000 KRW)"),
  THIRD(5, false, 1_500_000, "5 Matches (1,500,000 KRW)"),
  FOURTH(4, false, 50_000, "4 Matches (50,000 KRW)"),
  FIFTH(3, false, 5_000, "3 Matches (5,000 KRW)"),
  NONE(0, false, 0, "No prize")

  companion object {
    fun of(count: Int, hasBonus: Boolean): Rank = when (count) {
      6 -> FIRST
      5 -> if (hasBonus) SECOND else THIRD
      4 -> FOURTH
      3 -> FIFTH
      else -> NONE
    }
  }
}