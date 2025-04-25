package lotto

enum class WinningRank(val prize: Int) {
    FIRST(2_000_000_000),
    SECOND(30_000_000),
    THIRD(1_500_000),
    FOURTH(50_000),
    FIFTH(5_000),
    MISS(0);

    companion object {
        fun from(matchCount: Int, hasBonus: Boolean): WinningRank {
            return when (matchCount) {
                6 -> FIRST
                5 -> if (hasBonus) SECOND else THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> MISS
            }
        }
    }
}