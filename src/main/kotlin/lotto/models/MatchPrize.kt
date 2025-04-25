package lotto.models

enum class MatchPrize(
    val matchCount: Int,
    val matchBonus: Boolean,
    val prize: Int
) {
    SIX(6, false, 2_000_000_000),
    FIVEWITHBONUS(5, true, 30_000_000),
    FIVE(5, false, 1_500_000),
    FOUR(4, false, 50_000),
    THREE(3, false, 5_000),
    NONE(0, false, 0);

    companion object {
        fun from(matchCount: Int, matchBonus: Boolean): MatchPrize {
            return when {
                matchCount == 6 -> SIX
                matchCount == 5 && matchBonus -> FIVEWITHBONUS
                matchCount == 5 -> FIVE
                matchCount == 4 -> FOUR
                matchCount == 3 -> THREE
                else -> NONE
            }
        }
    }
}
