package lotto.domain

enum class LottoRank(
    val matchCount: Int,
    val prize: Int,
    val prizeString: String,
){
    FIRST(6,2_000_000_000, "6 Matches"),
    SECOND(5,30_000_000, "5 Matches + Bonus Ball"),
    THIRD(5,1_500_000, "5 Matches"),
    FOURTH(4,50_000, "4 Matches"),
    FIFTH(3,5_000, "3 Matches"),
    NONE(0,0, "No prize");

    companion object {
        fun valueOf (matchCount: Int, matchBonus: Boolean): LottoRank {
            if (matchCount == 6) return FIRST
            if (matchCount == 5 && matchBonus) return SECOND
            if (matchCount == 5) return THIRD
            if (matchCount == 4) return FOURTH
            if (matchCount == 3) return FIFTH
            return NONE
        }
    }
}
