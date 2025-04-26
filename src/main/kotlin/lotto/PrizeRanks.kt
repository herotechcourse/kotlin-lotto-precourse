package lotto

enum class PrizeRanks(
    val matchedNumbers: Int,
    val requiresBonus: Boolean,
    val prizeMoney: Int,
    val description: String
)
{
    NONE(0, false, 0, ""),
    FIFTH(3, false, 5_000, "3 Matches"),
    FOURTH(4, false, 50_000, "4 Matches"),
    THIRD(5, false, 1_500_000, "5 Matches"),
    SECOND(5, true, 30_000_000, "5 Matches + Bonus Ball"),
    FIRST(6, false, 2_000_000_000, "6 Matches");

    companion object {
        fun determineTier(matchedNumbers: Int, hasBonus: Boolean): PrizeRanks {
            return when {
                matchedNumbers == 6 -> FIRST
                matchedNumbers == 5 && hasBonus -> SECOND
                matchedNumbers == 5 -> THIRD
                matchedNumbers == 4 -> FOURTH
                matchedNumbers == 3 -> FIFTH
                else -> NONE
            }
        }
    }
}