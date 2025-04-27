package lotto

enum class Rank(val match: Int, val bonusRequired: Boolean, val prize: Long) {
  FIRST(6, false, 2_000_000_000L),
  SECOND(5, true, 30_000_000L),
  THIRD(5, false, 1_500_000L),
  FOURTH(4, false, 50_000L),
  FIFTH(3, false, 5_000L);

  companion object {
    fun of(match: Int, bonus: Boolean): Rank? = when {
      match == 6 -> FIRST
      match == 5 && bonus -> SECOND
      match == 5 -> THIRD
      match == 4 -> FOURTH
      match == 3 -> FIFTH
      else -> null
    }
  }
}
