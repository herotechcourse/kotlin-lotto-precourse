package lotto

enum class Rank(val matchingCount: Int, val prize: Int) {
  THREE_MATCHES(3, 5000),
  FOUR_MATCHES(4, 50000),
  FIVE_MATCHES(5, 1500000),
  FIVE_MATCHES_WITH_BONUS(5, 30000000),
  SIX_MATCHES(6, 2000000000);

  companion object {
    fun findByMatchAndBonus(matchCount: Int, hasBonus: Boolean): Rank? {
      return when {
        matchCount == 6 -> SIX_MATCHES
        matchCount == 5 && hasBonus -> FIVE_MATCHES_WITH_BONUS
        matchCount == 5 -> FIVE_MATCHES
        matchCount == 4 -> FOUR_MATCHES
        matchCount == 3 -> THREE_MATCHES
        else -> null
      }
    }
  }
}