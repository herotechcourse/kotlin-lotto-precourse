package lotto.enums

enum class LottoRank(
    val matchCount: Int,
    val prize: Int,
    val hasBonus: Boolean = false
) {
    FIFTH(3, 5_000),
    FOURTH(4, 50_000),
    THIRD(5, 1_500_000),
    SECOND(5, 30_000_000, true),
    FIRST(6, 2_000_000_000);

    companion object {
        fun valueOfMatchCount(matchCount: Int, hasBonus: Boolean): LottoRank {
            return when {
                matchCount == 6 -> FIRST
                matchCount == 5 && hasBonus -> SECOND
                matchCount == 5 -> THIRD
                matchCount == 4 -> FOURTH
                else -> FIFTH
            }
        }
    }
}
