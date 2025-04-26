package lotto.model

enum class MatchRank(
    private val matchedCount: Int,
    val prize: Int,
    private val message: String
) {
    FIRST(6, 2_000_000_000,"6 Matches"),
    SECOND(5, 30_000_000,"5 Matches + Bonus Ball"),
    THIRD(5, 1_500_000,"5 Matches"),
    FOURTH(4, 50_000,"4 Matches"),
    FIFTH(3, 5_000,"3 Matches"),
    NONE(0, 0,"");

    companion object {
        fun of(matchedCount: Int, bonusMatched: Boolean): MatchRank {
            if (matchedCount == 6) return FIRST
            if (matchedCount == 5 && bonusMatched) return SECOND
            if (matchedCount == 5) return THIRD
            if (matchedCount == 4) return FOURTH
            if (matchedCount == 3) return FIFTH
            if (matchedCount < 3) return NONE
            throw IllegalArgumentException("[ERROR] Invalid matched count: $matchedCount")
        }
    }

    fun toMessage(): String {
        if (this == NONE) return ""
        return "$message (${formatPrize()})"
    }

    private fun formatPrize(): String {
        return "%,d".format(prize) + " KRW"
    }
}
