package lotto

enum class LottoRank(val matchCount: Int, val prize: Long, val description: String) {
    /** First prize: 6 matches */
    FIRST(6, 2_000_000_000L, "6 Matches (%,d KRW)"),
    /** Second prize: 5 matches + bonus number match */
    SECOND(5, 30_000_000L, "5 Matches + Bonus Ball (%,d KRW)"),
    /** Third prize: 5 matches (no bonus ball) */
    THIRD(5, 1_500_000L, "5 Matches (%,d KRW)"),
    /** Fourth prize: 4 matches */
    FOURTH(4, 50_000L, "4 Matches (%,d KRW)"),
    /** Fifth prize: 3 matches */
    FIFTH(3, 5_000L, "3 Matches (%,d KRW)"),
    /** No prize: Less than 3 matches */
    MISS(0, 0L, "");

    fun getFormattedDescription(): String {
        return if (prize > 0) {
            description.format(prize) // Format prize into the description string
        } else {
            description // Return the base description (empty string for MISS)
        }
    }

    companion object {
        /** Determines the LottoRank based on the number of matched numbers and whether the bonus number matched. */
        fun valueOf(matchCount: Int, bonusMatch: Boolean): LottoRank {
            return when (matchCount) {
                6 -> FIRST
                5 -> if (bonusMatch) SECOND else THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> MISS
            }
        }
    }
}
