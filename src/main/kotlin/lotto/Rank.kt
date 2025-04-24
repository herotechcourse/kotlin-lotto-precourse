package lotto

enum class Rank(val matchCount: Int, val prize: Int, val requiresBonus: Boolean = false) {
    FIRST(6, Constants.FIRST_PRIZE, false),
    SECOND(5, Constants.SECOND_PRIZE, true),
    THIRD(5, Constants.THIRD_PRIZE, false),
    FOURTH(4, Constants.FOURTH_PRIZE, false),
    FIFTH(3, Constants.FIFTH_PRIZE, false),
    WITHOUT(0, 0, false);

    companion object {
        fun from(matchCount: Int, hasBonus: Boolean): Rank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && hasBonus -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> WITHOUT
            }
        }
    }
}