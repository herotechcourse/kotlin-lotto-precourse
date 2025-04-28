package lotto

enum class Rank(
    val matchCount: Int,
    val prize: Int,
    val requiresBonus: Boolean = false
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    companion object {
        fun from(matchCount: Int, bonusMatched: Boolean): Rank {
            if (matchCount == 6) {
                return FIRST
            }
            if (matchCount == 5 && bonusMatched) {
                return SECOND
            }
            if (matchCount == 5) {
                return THIRD
            }
            if (matchCount == 4) {
                return FOURTH
            }
            if (matchCount == 3) {
                return FIFTH
            }
            return NONE
        }
    }
}
