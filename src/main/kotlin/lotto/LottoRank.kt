package lotto

enum class LottoRank(
    val matchCount: Int,
    val hasBonus: Boolean,
    val prize: Long,
    val description: String
) {
    FIRST(6, false, 2_000_000_000, "6 Matches"),
    SECOND(5, true, 30_000_000, "5 Matches + Bonus Ball"),
    THIRD(5, false, 1_500_000, "5 Matches"),
    FOURTH(4, false, 50_000, "4 Matches"),
    FIFTH(3, false, 5_000, "3 Matches"),
    NONE(0, false, 0, "No Match");

    companion object {
        fun calculateRank(matchCount: Int, hasBonus: Boolean): LottoRank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && hasBonus -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                matchCount == 3 -> FIFTH
                else -> NONE
            }
        }
    }
}