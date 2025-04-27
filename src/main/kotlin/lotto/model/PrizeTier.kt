package lotto.model

enum class PrizeTier(val matchCount: Int, val hasBonusMatch: Boolean, val prizeMoney: Long, val description: String) {
    FIRST(6, false, 2000000000, "6 Matches"),
    SECOND(5, true, 30000000, "5 Matches + Bonus Ball"),
    THIRD(5, false, 1500000, "5 Matches"),
    FOURTH(4, false, 50000, "4 Matches"),
    FIFTH(3, false, 5000, "3 Matches"),
    NONE(0, false, 0, "No Matches");

    companion object {
        fun calculate(matchCount: Int, hasBonusMatch: Boolean): PrizeTier {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && hasBonusMatch -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> NONE
            }
        }
    }
}