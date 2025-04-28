package lotto

enum class Prize(val matchCount: Int, val reward: Long, val needsBonus: Boolean, val description: String) {
    FIRST(6, 2_000_000_000L, false, "6 Matches"),
    SECOND(5, 30_000_000L, true, "5 Matches + Bonus Ball"),
    THIRD(5, 1_500_000L, false, "5 Matches"),
    FOURTH(4, 50_000L, false, "4 Matches"),
    FIFTH(3, 5_000L, false, "3 Matches"),
    MISS(0, 0L, false, "");

    companion object {
        fun from(matchCount: Int, hasBonus: Boolean): Prize? {
            return when (matchCount) {
                6 -> FIRST
                5 -> if (hasBonus) SECOND else THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> null
            }
        }
    }
}