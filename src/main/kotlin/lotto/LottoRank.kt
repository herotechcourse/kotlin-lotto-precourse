package lotto

enum class LottoRank(
    val matchCount: Int,
    val prize: Int
) {

    FIRST(6, 2_000_000_000),
    SECOND(5, 30_000_000),
    THIRD(5, 1_500_000),
    FOURTH(4, 50_000),
    FIFTH(3, 5_000),
    NONE(0, 0);

    companion object {
        fun findByMatch(matchCount: Int, isBonusMatched: Boolean): LottoRank {
            if (matchCount !in 0..6) {
                throw IllegalArgumentException("[ERROR] The number of matched numbers must be between 0 and 6.")
            }

            return when (matchCount) {
                6 -> FIRST
                5 -> if (isBonusMatched) SECOND else THIRD
                4 -> FOURTH
                3 -> FIFTH
                else -> NONE
            }
        }
    }
}
