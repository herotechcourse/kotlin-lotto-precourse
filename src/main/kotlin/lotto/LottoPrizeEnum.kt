package lotto

enum class LottoPrizeEnum(val matchCount: Int, val prize: Int) {
    THREE(3, 5_000),
    FOUR(4, 50_000),
    FIVE(5, 1_500_000),
    FIVE_WITH_BONUS(5, 30_000_000),
    SIX(6, 2_000_000_000);

    companion object {
        fun from(matchCount: Int, matchBonus: Boolean = false): LottoPrizeEnum? {
            return when {
                matchCount == 6 -> SIX
                matchCount == 5 && matchBonus -> FIVE_WITH_BONUS
                matchCount == 5 -> FIVE
                matchCount == 4 -> FOUR
                matchCount == 3 -> THREE
                else -> null
            }
        }
    }
}