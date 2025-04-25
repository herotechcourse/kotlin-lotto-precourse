package lotto.model

enum class LottoRank(
    val matchCount: Int,
    val matchBonus: Boolean,
    val prize: Int,
    val description: String
) {
    FIRST(6, false, 2000000000, "6 Matches (2,000,000,000 KRW)"),
    SECOND(5, true, 30000000, "5 Matches + Bonus Ball (30,000,000 KRW)"),
    THIRD(5, false, 1500000, "5 Matches (1,500,000 KRW)"),
    FOURTH(4, false, 50000, "4 Matches (50,000 KRW)"),
    FIFTH(3, false, 5000, "3 Matches (5,000 KRW)"),
    NOTHING(0, false, 0, "");

    companion object {
        fun of(matchCount: Int, matchBonus: Boolean): LottoRank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && matchBonus -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> NOTHING
            }
        }
    }
}
