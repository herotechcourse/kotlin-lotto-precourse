package lotto

enum class Rank(
    val matchCount: Int,
    val hasBonus: Boolean,
    val prize: Int
) {
    FIRST(6, false, 2_000_000_000),
    SECOND(5, true, 30_000_000),
    THIRD(5, false, 1_500_000),
    FOURTH(4, false, 50_000),
    FIFTH(3, false, 5_000);

    companion object {
        fun findRank(matchCount: Int, bonusMatch: Boolean): Rank? {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && bonusMatch -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> null
            }
        }
    }
}
