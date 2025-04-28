package lotto

enum class Rank(
    val matchCount: Int,
    val prize: Int,
    val requireBonus: Boolean = false,
) {
    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000, requireBonus = true),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(-1, 0);

    companion object {
        fun from(matchCount: Int, matchBonus: Boolean): Rank {
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