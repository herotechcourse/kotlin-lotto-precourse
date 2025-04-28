package lotto

enum class Prize(val matchCount: Int, val prizeMoney: Int) {
    FIRST(6, 2_000_000_000),
    SECOND_BONUS(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    companion object {
        fun getPrize(matchCount: Int, hasBonus: Boolean): Prize {
            return when (matchCount) {
                6 -> FIRST
                5 -> if (hasBonus) SECOND_BONUS else THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> NONE
            }
        }
    }
}