package lotto

enum class LottoResult(val matchCount: Int, val hasBonusMatch: Boolean, val prize: Long, val description: String) {
    FIFTH(3, false, 5_000, "3 Matches"),
    FOURTH(4, false, 50_000, "4 Matches"),
    THIRD(5, false, 1_500_000, "5 Matches"),
    SECOND(5, true, 30_000_000, "5 Matches + Bonus Ball"),
    FIRST(6, false, 2_000_000_000, "6 Matches"),
    NONE(0, false, 0, "No Match");

    companion object {
        fun from(matchCount: Int, hasBonusMatch: Boolean): LottoResult {
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